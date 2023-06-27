import sys
from collections import deque

input = sys.stdin.readline

N = int(input().rstrip())
K = int(input().rstrip())

grid = [[0] * (N+1) for _ in range(N+1)]

for i in range(K):
    x, y = map(int, input().split())

    grid[x][y] = 2

L = int(input().rstrip())

turn = []
for i in range(L):
    count, dir = input().split()
    turn.append((int(count), dir))

idx = 0
time = 0
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

dir = 1
tail = deque()
tail.append((1, 1))

x, y = 1, 1

while True:
    time += 1

    nx = x + dx[dir]
    ny = y + dy[dir]

    if 1 <= nx <= N and 1 <= ny <= N and ((nx, ny)) not in tail:
        if grid[nx][ny] == 2:
            tail.append((nx, ny))
            grid[nx][ny] = 0
        elif grid[nx][ny] == 0:
            tail.popleft()
            tail.append((nx, ny))
    else:
        print(time)
        break

    x = nx
    y = ny

    if idx < len(turn) and time == turn[idx][0]:
        if turn[idx][1] == 'D':
            dir = (dir + 1) % 4
        else:
            dir = (dir + 3) % 4
        idx += 1
