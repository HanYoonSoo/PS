import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
                if graph[nx][ny] == 1:
                    graph[nx][ny] += 1
                else:
                    q.append((nx, ny))
                visited[nx][ny] = True

count = 0
before = 0
while True:
    visited = [[False] * M for _ in range(N)]

    bfs()

    compare = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] >= 2:
                graph[i][j] = 0
                compare += 1


    if compare == 0:
        break
    else:
        before = compare

    count += 1

print(count)
print(before)
