import sys
from collections import deque

input = sys.stdin.readline

R, C = map(int, input().split())

grid = []

q_j = deque()
q_f = deque()

visitedj = [[0] * C for _ in range(R)]
visitedf = [[0] * C for _ in range(R)]

for i in range(R):
    temp = list(input().rstrip())
    for j in range(C):
        if temp[j] == 'J':
            q_j.append((i, j))
            visitedj[i][j] = 1
        elif temp[j] == 'F':
            q_f.append((i, j))
            visitedf[i][j] = 1

    grid.append(temp)

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q_f:
        x, y = q_f.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if not visitedf[nx][ny] and grid[nx][ny] != '#':
                    visitedf[nx][ny] = visitedf[x][y] + 1
                    q_f.append((nx, ny))

    while q_j:
        x, y = q_j.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                if not visitedj[nx][ny] and grid[nx][ny] != '#':
                    if not visitedf[nx][ny] or visitedf[nx][ny] > visitedj[x][y] + 1:
                        visitedj[nx][ny] = visitedj[x][y] + 1
                        q_j.append((nx, ny))
            else:
                return visitedj[x][y]

    return "IMPOSSIBLE"
print(bfs())