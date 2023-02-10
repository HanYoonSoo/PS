import sys

input = sys.stdin.readline

N, M, x, y, K = map(int, input().split())

graph = []
dice = [0, 0, 0, 0, 0, 0]
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0] # 동, 서, 북, 남

for _ in range(N):
    graph.append(list(map(int, input().split())))

command = list(map(int, input().split()))

def move(dir):
    global dice
    a, b, c, d, e, f = dice

    if dir == 0:
        dice = list((a, f, c, e, b, d))
    elif dir == 1:
        dice = list((a, e, c, f, d, b))
    elif dir == 2:
        dice = list((d, a, b, c, e, f))
    else:
        dice = list((b, c, d, a, e, f))

for i in command:
    x = x + dx[i-1]
    y = y + dy[i-1]

    if x < 0 or y < 0 or x >= N or y >= M:
        x -= dx[i-1]
        y -= dy[i-1]
        continue

    move(i-1)

    if graph[x][y] == 0:
        graph[x][y] = dice[1]
    else:
        dice[1] = graph[x][y]
        graph[x][y] = 0

    print(dice[3])




