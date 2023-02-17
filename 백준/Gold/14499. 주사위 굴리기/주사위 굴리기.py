import sys
input = sys.stdin.readline
N, M, x, y, K = map(int, input().split())

graph = []
dice = [0, 0, 0, 0, 0, 0]
for _ in range(N):
    graph.append(list(map(int, input().split())))

turn = list(map(int, input().split()))

dice[1] = graph[x][y]
graph[x][y] = 0

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def move(dir):
    global dice
    a, b, c, d, e, f = dice

    if dir == 0:
        dice = list((a, f, c, e, b, d))
    elif dir == 1:
        dice = list((a, e, c, f, d, b))
    elif dir == 2:
        dice = list((d, a, b, c, e, f))
    elif dir == 3:
        dice = list((b, c, d, a, e, f))

for command in turn:
    x = x + dx[command-1]
    y = y + dy[command-1]

    if 0 <= x < N and 0 <= y < M:
        move(command - 1)
        if graph[x][y] == 0:
            graph[x][y] = dice[1]
        else:
            dice[1] = graph[x][y]
            graph[x][y] = 0
        print(dice[3])
    else:
        x -= dx[command-1]
        y -= dy[command-1]

    



