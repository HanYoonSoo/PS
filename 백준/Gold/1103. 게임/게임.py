import sys

sys.setrecursionlimit(10 ** 9)
input = sys.stdin.readline

N, M = map(int, input().split())

graph = []

for i in range(N):
    temp = list(input().rstrip())
    for j in range(M):
        if temp[j] == 'H':
            temp[j] = '0'
    graph.append(list(map(int, temp)))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[False] * M for _ in range(N)]
dp = [[0] * M for _ in range(N)]

def dfs(x, y, depth):
    global result
    # print(x, y, depth)
    result = max(result, depth)

    for i in range(4):
        nx = x + graph[x][y] * dx[i]
        ny = y + graph[x][y] * dy[i]

        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] != 0 and depth + 1 > dp[nx][ny]:
            if visited[nx][ny]:
                print(-1)
                exit(0)
            else:
                dp[nx][ny] = depth + 1
                visited[nx][ny] = True
                dfs(nx, ny, depth+1)
                visited[nx][ny] = False

result = 0

dfs(0, 0, 0)

print(result+1)
