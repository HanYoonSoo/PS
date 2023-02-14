import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

def bfs(i, j, value):
    q = deque()

    q.append((i, j))
    visited[i][j] = True
    count = 1

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == value and not visited[nx][ny]:
                q.append((nx, ny))
                visited[nx][ny] = True
                count += 1

    return count


count = 0
result = []
visited = [[False] * N for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for i in range(N):
    for j in range(N):
        if graph[i][j] != 0 and not visited[i][j]:
            result.append(bfs(i, j, graph[i][j]))
            count += 1

print(count)

result.sort()
print('\n'.join(map(str, result)))
