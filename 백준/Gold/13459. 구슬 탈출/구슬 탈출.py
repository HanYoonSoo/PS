import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = []
rx, ry, bx, by = 0, 0, 0, 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
visited = [[[[False] * M for _ in range(N)] for _ in range(M)] for _ in range(N)]

for i in range(N):
    graph.append(list(input().rstrip()))

    if 'R' in graph[i]:
        rx, ry = i, graph[i].index('R')
    if 'B' in graph[i]:
        bx, by = i, graph[i].index('B')

q = deque()
q.append((rx, ry, bx, by, 1))
visited[rx][ry][bx][by] = True

def move(x, y, dx, dy):
    count = 0

    while graph[x+dx][y+dy] != '#' and graph[x][y] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count

while q:
    rx, ry, bx, by, depth = q.popleft()

    if depth > 10:
        print(0)
        exit(0)

    for i in range(4):
        nrx, nry, rcount = move(rx, ry, dx[i], dy[i])
        nbx, nby, bcount = move(bx, by, dx[i], dy[i])

        if graph[nbx][nby] != 'O':
            if graph[nrx][nry] == 'O':
                print(1)
                exit(0)

            if nrx == nbx and nry == nby:
                if rcount > bcount:
                    nrx -= dx[i]
                    nry -= dy[i]
                else:
                    nbx -= dx[i]
                    nby -= dy[i]

            if not visited[nrx][nry][nbx][nby]:
                visited[nrx][nry][nbx][nby] = True
                q.append((nrx, nry, nbx, nby, depth + 1))

print(0)