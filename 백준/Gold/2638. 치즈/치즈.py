import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():

    q = deque()
    q.append((0, 0))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if graph[nx][ny] >= 1:
                    graph[nx][ny] += 1
                else:
                    q.append((nx, ny))
                    visited[nx][ny] = True

result = 0

while True:
    visited = [[False] * M for _ in range(N)]

    bfs()

    compare = False

    for i in range(N):
        for j in range(M):
            if graph[i][j] >= 3:
                graph[i][j] = 0
                compare = True
            elif graph[i][j] == 2:
                graph[i][j] = 1

    if not compare:
        break

    result += 1

print(result)

