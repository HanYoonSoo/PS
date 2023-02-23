import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())

grid = []

x, y = 0, 0
for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        if temp[j] == 9:
            x, y = i, j
    grid.append(temp)

grid[x][y] = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

size = 2
eat = 0
time = 0
q = deque()
q.append((x, y, 0))

while True:
    fish = []
    visited = [[False] * N for _ in range(N)]

    while q:
        x, y, count = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and grid[nx][ny] <= size:
                visited[nx][ny] = True
                q.append((nx, ny, count + 1))
                if 1 <= grid[nx][ny] <= 6 and grid[nx][ny] < size:
                    fish.append((nx, ny, count + 1))

    if len(fish) == 0:
        print(time)
        break

    fish.sort(key=lambda x: (x[2], x[0], x[1]))
    a, b, c = fish[0]

    time += c
    grid[a][b] = 0
    q.append((a, b, 0))
    eat += 1

    if eat >= size:
        eat = 0
        size += 1
