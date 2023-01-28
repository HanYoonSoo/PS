import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().strip())))

def bfs(a, b):
    q = deque([])
    q.append([a, b, 1])
    visited = [[False] * M for _ in range(N)]
    visited[a][b] = True

    while q:
        x, y, count = q.popleft()

        if x == N-1 and y == M-1:
            return count

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1 and not visited[nx][ny]:
                visited[nx][ny] = True
                q.append([nx, ny, count + 1])

print(bfs(0, 0))