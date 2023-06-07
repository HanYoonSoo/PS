import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())

distance = [[0] * (N + 1) for _ in range(N + 1)]
dp = [[0] * (M + 1) for _ in range(N + 1)]

for _ in range(K):
    a, b, c = map(int, input().split())
    distance[a][b] = max(distance[a][b], c)

for i in range(2, N + 1):
    dp[i][2] = distance[1][i]

for i in range(2, N + 1):
    for j in range(3, M + 1):
        for k in range(1, i):
            if distance[k][i] and dp[k][j - 1]:
                dp[i][j] = max(dp[k][j-1] + distance[k][i], dp[i][j])

print(max(dp[N]))


