import sys
input = sys.stdin.readline
N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, total, count):
    global result

    if count == 4:
        result = max(result, total)
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny, total + graph[nx][ny], count + 1)
            visited[nx][ny] = False

def exce(x, y):
    global result

    for i in range(4):
        total = graph[x][y]
        for j in range(3):
            dir_idx = (i + j) % 4
            nx = x + dx[dir_idx]
            ny = y + dy[dir_idx]

            if 0 <= nx < N and 0 <= ny < M:
                total += graph[nx][ny]

        result = max(result, total)


visited = [[False] * M for _ in range(N)]
result = 0

for i in range(N):
    for j in range(M):
        visited[i][j] = True
        dfs(i, j, graph[i][j], 1)
        visited[i][j] = False

        exce(i, j)

print(result)