import sys

input = sys.stdin.readline

N = int(input().rstrip())

dp = [[] for _ in range(N)]

for i in range(N):
    dp[i] = list(map(int, input().split()))

for i in range(1, N):
    for j in range(i+1):
        if j == 0:
            dp[i][0] += dp[i-1][0]
        elif j == i:
            dp[i][-1] += dp[i-1][-1]
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[N-1]))