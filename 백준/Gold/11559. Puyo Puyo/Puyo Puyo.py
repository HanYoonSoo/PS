import sys
from collections import deque

graph = []

for i in range(12):
    graph.append(list(sys.stdin.readline().rstrip()))

def bfs(i, j):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q = deque()
    q.append((i, j))
    temp.append((i, j))

    visited[i][j] = True

    while q:
        x, y = q.popleft()

        for dir in range(4):
            nx = x + dx[dir]
            ny = y + dy[dir]

            if 0 <= nx < 12 and 0 <= ny < 6 and graph[nx][ny] == graph[i][j] and not visited[nx][ny]:
                visited[nx][ny] = True
                temp.append((nx, ny))
                q.append((nx, ny))

def delete(temp):
    for x, y in temp:
        graph[x][y] = '.'

def move():
    for i in range(6):
        for j in range(10, -1, -1):
            for k in range(11, j, -1):
                if graph[j][i] != '.' and graph[k][i] == '.':
                    graph[k][i] = graph[j][i]
                    graph[j][i] = '.'
                    break

count = 0

while True:
    visited = [[False] * 6 for _ in range(12)]
    compare = False
    for i in range(12):
        for j in range(6):
            if graph[i][j] != '.' and not visited[i][j]:
                visited[i][j] = True
                temp = []
                bfs(i, j)

                if len(temp) >= 4:
                    compare = True
                    delete(temp)

    if not compare:
        break

    move()
    count += 1

print(count)

