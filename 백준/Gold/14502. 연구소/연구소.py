import copy
import sys
from collections import deque

input = sys.stdin.readline

def spread_virus(x, y, temp_grid):
    queue = deque()
    queue.append((x, y))

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and temp_grid[nx][ny] == 0:
                temp_grid[nx][ny] = 2
                queue.append((nx, ny))

def count_safe(temp_grid):
    count = 0
    for i in range(N):
        count += temp_grid[i].count(0)

    return count
def dfs(start, depth):
    global maxNum

    if depth == 3:
        temp_grid = copy.deepcopy(grid)

        for x, y in virus:
            spread_virus(x, y, temp_grid)

        maxNum = max(maxNum, count_safe(temp_grid))
        return

    for i in range(start, N * M):
        r = i // M
        c = i % M

        if grid[r][c] == 0:
            grid[r][c] = 1
            dfs(i+1, depth + 1)
            grid[r][c] = 0



N, M = map(int, input().split())

grid = []
virus = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(M):
        if temp[j] == 2:
            virus.append((i, j))
    grid.append(temp)

maxNum = 0
dfs(0, 0)

print(maxNum)

