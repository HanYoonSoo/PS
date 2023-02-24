import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

virus = [[] for _ in range(K+1)]

grid = []

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        if temp[j] != 0:
            virus[temp[j]].append((i, j))
    grid.append(temp)

S, X, Y = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y, num, temp_virus):
    q = deque()
    q.append((x, y))

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < N and grid[nx][ny] == 0:
            grid[nx][ny] = num
            if (nx, ny) not in temp_virus:
                temp_virus.append((nx, ny))

for _ in range(S):
    for i in range(1, K+1):
        temp_virus = []
        for x, y in virus[i]:
            bfs(x, y, i, temp_virus)
        virus[i] = temp_virus

if grid[X-1][Y-1] != 0:
    print(grid[X-1][Y-1])
else:
    print(0)
