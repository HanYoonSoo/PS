import sys
from collections import deque

input = sys.stdin.readline

def bfs(a, b):
    q = deque()
    visited[a][b] = True

    q.append((a, b))
    o = 0
    v = 0

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny] and grid[nx][ny] != '#':
                if grid[nx][ny] == 'o':
                    o += 1
                elif grid[nx][ny] == 'v':
                    v += 1

                visited[nx][ny] = True
                q.append((nx, ny))

    return v, o

N, M = map(int, input().split())

grid = []

for i in range(N):
    grid.append(list(input().rstrip()))

visited = [[False] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

sheep = 0
wolf = 0

for i in range(N):
    for j in range(M):
        if not visited[i][j] and grid[i][j] != '#':
            v, o = bfs(i, j)

            if grid[i][j] == 'o':
                o += 1
            elif grid[i][j] == 'v':
                v += 1

            if v >= o:
                wolf += v
            else:
                sheep += o

print(sheep, wolf)
