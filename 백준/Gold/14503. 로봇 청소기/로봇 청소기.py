import sys

input = sys.stdin.readline
N, M = map(int, input().split())

nx, ny, dir = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1] # 북 동 남 서

dir_idx = 0

count = 0

if graph[nx][ny] == 0:
    graph[nx][ny] = 2
    count = 1

compare = 0

while True:

    dir = (dir + 3) % 4
    nx = nx + dx[dir]
    ny = ny + dy[dir]

    if 1 <= nx < N and 1 <= ny < M and graph[nx][ny] == 0:
        graph[nx][ny] = 2
        count += 1
        compare = 0

    else:
        nx -= dx[dir]
        ny -= dy[dir]
        compare += 1

    if compare == 4:
        nx -= dx[dir]
        ny -= dy[dir]

        if 1 <= nx < N and 1 <= ny < M:
            if graph[nx][ny] == 1:
                break
            else:
                compare = 0
        else:
            break

print(count)


