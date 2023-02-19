import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline
T = int(input().rstrip())

def dfs(x, y):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 1:
            graph[nx][ny] = 0
            dfs(nx, ny)

for _ in range(T):
    M, N, K = map(int, input().split())

    graph = [[0] * M for _ in range(N)]

    for _ in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1

    count = 0

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                graph[i][j] = 0
                dfs(i, j)
                count += 1

    print(count)
