from collections import deque
import sys

M, N = map(int ,sys.stdin.readline().split())

grid = []
for i in range(N):
    grid.append(list(map(int, sys.stdin.readline().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

q = deque([])

for i in range(N):
    for j in range(M):
        if grid[i][j] == 1:
            q.append([i, j])

def bfs():
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and nx < N and ny >= 0 and ny < M:
                if grid[nx][ny] == 0:
                    q.append([nx, ny])
                    grid[nx][ny] = grid[x][y] + 1

bfs()

result = 0

for i in range(N):
    if grid[i].count(0):
        print(-1)
        exit()
    else:
        result = max(result, max(grid[i]))

print(result - 1)




