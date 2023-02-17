import sys

input = sys.stdin.readline

N, M = map(int, input().split())

x, y, dir = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

graph[x][y] = 2
count = 1
compare = 0

while True:
    dir = (dir + 3) % 4

    x += dx[dir]
    y += dy[dir]

    if 0 <= x < N and 0 <= y < M and graph[x][y] == 0:
        graph[x][y] = 2
        count += 1
        compare = 0
    else:
        x -= dx[dir]
        y -= dy[dir]
        compare += 1

    if compare == 4:
        x -= dx[dir]
        y -= dy[dir]

        if 0 <= x < N and 0 <= y < M and graph[x][y] == 1:
            break
        else:
            compare = 0

print(count)
