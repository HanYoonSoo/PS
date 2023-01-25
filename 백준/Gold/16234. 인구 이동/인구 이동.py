from collections import deque

N, L, R = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(a, b):
    q = deque()
    temp = []
    q.append((a,b))
    temp.append((a,b))

    while q:

        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N or visited[nx][ny]:
                continue

            if L <= abs(graph[x][y] - graph[nx][ny]) <= R:
                visited[nx][ny] = True
                q.append((nx, ny))
                temp.append((nx,ny))

    return temp

result = 0

while True:
    visited = [[False] * N for _ in range(N)]
    compare = False

    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                visited[i][j] = True
                country = bfs(i, j)

                if len(country) > 1:
                    compare = True

                    divide = 0
                    for x, y in country:
                        divide += graph[x][y]

                    divide = divide // len(country)

                    for x, y in country:
                        graph[x][y] = divide

    if not compare:
        break
    result += 1

print(result)



