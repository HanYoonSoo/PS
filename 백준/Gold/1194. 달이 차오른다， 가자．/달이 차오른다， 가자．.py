from collections import deque

class Node:
    def __init__(self, x, y, dist, key):
        self.x = x
        self.y = y
        self.dist = dist
        self.key = key
N, M = map(int, input().split())

graph = []

for i in range(N):
    graph.append(list(input()))
    if '0' in graph[i]:
        start = Node(i, graph[i].index('0'), 0, 0)
        graph[i][graph[i].index('0')] = '.'

visited = [[[False] * M for _ in range(N)] for _ in range(64)]
alphaL = ['a', 'b', 'c', 'd', 'e', 'f']
alphaU = ['A', 'B', 'C', 'D', 'E', 'F']

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(start):
    q = deque()
    q.append(start)

    while q:
        node = q.popleft()
        x = node.x
        y = node.y
        dist = node.dist
        key = node.key

        if graph[x][y] == '1':
            print(dist)
            exit(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] != '#' and not visited[key][nx][ny]:
                if graph[nx][ny] in alphaL:
                    newkey = key | (1 << (ord(graph[nx][ny]) - ord('a')))
                    if not visited[newkey][nx][ny]:
                        visited[newkey][nx][ny] = True
                        visited[key][nx][ny] = True
                        q.append(Node(nx, ny, dist + 1, newkey))
                elif graph[nx][ny] in alphaU:
                    door = 1 << (ord(graph[nx][ny]) - ord('A'))

                    if key & door > 0:
                        if not visited[key][nx][ny]:
                            visited[key][nx][ny] = True
                            q.append(Node(nx, ny, dist + 1, key))
                else:
                    q.append(Node(nx, ny, dist + 1, key))
                    visited[key][nx][ny] = True

bfs(start)

print(-1)
