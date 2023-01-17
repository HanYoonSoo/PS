from collections import deque
import sys

M, N, H = map(int ,sys.stdin.readline().split())

grid = []
q = deque([])

for i in range(H):
    temp = []
    for j in range(N):
        temp.append(list(map(int, sys.stdin.readline().split())))
        for k in range(M):
            if temp[j][k] == 1:
                q.append([i,j,k])
    grid.append(temp)

dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

def bfs():
    while q:
        z, x, y = q.popleft()

        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]

            if nz >= 0 and nz < H and nx >= 0 and nx < N and ny >= 0 and ny < M:
                if grid[nz][nx][ny] == 0:
                    q.append([nz, nx, ny])
                    grid[nz][nx][ny] = grid[z][x][y] + 1

bfs()

result = 0

for i in range(H):
    for j in range(N):
        if grid[i][j].count(0):
            print(-1)
            exit()
        else:
            result = max(result, max(grid[i][j]))

print(result - 1)




