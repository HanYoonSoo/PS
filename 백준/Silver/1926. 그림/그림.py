import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y):
    global temp
    graph[x][y] = 0

    temp += 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
            dfs(nx, ny)

result = 0
count = 0

for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            temp = 0
            dfs(i, j)
            result = max(result, temp)
            count += 1

print(count, result, sep='\n')