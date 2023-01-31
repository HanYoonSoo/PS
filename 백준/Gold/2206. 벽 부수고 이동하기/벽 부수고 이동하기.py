import sys
from collections import deque

class Node:
    def __init__(self, x, y, count, destroy = False):
        self.x = x
        self.y = y
        self.count = count
        self.destroy = destroy

N, M = map(int, sys.stdin.readline().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input())))

visited = [[[False for _ in range(2)] for _ in range(M)] for _ in range(N)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque()

q.append(Node(0, 0, 1, False))
visited[0][0][0] = True

while q:
    node = q.popleft()

    if node.x == N-1 and node.y == M-1:
        print(node.count)
        exit(0)
    for i in range(4):
        nx = node.x + dx[i]
        ny = node.y + dy[i]
        ncount = node.count + 1

        if 0 <= nx < N and 0 <= ny < M:
            if graph[nx][ny] == 0:
                if not node.destroy and not visited[nx][ny][0]:
                    q.append(Node(nx, ny, ncount, False))
                    visited[nx][ny][0] = True
                elif node.destroy and not visited[nx][ny][1]:
                    q.append(Node(nx, ny, ncount, True))
                    visited[nx][ny][1] = True
            elif graph[nx][ny] == 1:
                if not node.destroy:
                    q.append(Node(nx, ny, ncount, True))
                    visited[nx][ny][1] = True

print(-1)