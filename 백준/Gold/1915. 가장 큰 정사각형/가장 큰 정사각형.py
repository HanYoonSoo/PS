import sys
N, M = map(int, sys.stdin.readline().split())

arr = []
dp = [[0] * M for _ in range(N)]

for i in range(N):
    arr.append(list(map(int, list(sys.stdin.readline().rstrip()))))

result = 0
for i in range(N):
    for j in range(M):
        if i == 0 or j == 0:
            dp[i][j] = arr[i][j]
        elif arr[i][j] == 0:
            dp[i][j] = 0
        else:
            dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) +1
        result = max(dp[i][j], result)


print(result ** 2)
