import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = [[0] * (N+1) for _ in range(N+1)]

K = int(input())

for _ in range(K):
    x, y = map(int, input().split())
    graph[x][y] = 2

L = int(input())
direction = []

for _ in range(L):
    count, dir = input().split()
    count = int(count)
    direction.append((count, dir))

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

dir_idx = 0

snake = [1, 1]
count = 0
sx, sy = 1, 1

tail = deque()

tail.append((1, 1))
graph[1][1] = 1

while True:
    count += 1
    sx += dx[dir_idx]
    sy += dy[dir_idx]

    if sx > N or sy > N or sx < 1 or sy < 1:
        break

    if graph[sx][sy] == 2:
        graph[sx][sy] = 1
        tail.append((sx, sy))
    elif graph[sx][sy] == 0:
        graph[sx][sy] = 1
        tail.append((sx, sy))
        tx, ty = tail.popleft()
        graph[tx][ty] = 0
    else:
        break

    if len(direction) > 0 and count == direction[0][0]:
        if direction[0][1] == 'L':
            dir_idx = (dir_idx - 1) % 4
        elif direction[0][1] == 'D':
            dir_idx = (dir_idx + 1) % 4
        direction.pop(0)

print(count)






