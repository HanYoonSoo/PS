import sys

N, K = map(int, sys.stdin.readline().split())

arr = []

for _ in range(N):
    arr.append(int(sys.stdin.readline()))
dp = [0] * (K+1)

dp[0] = 1

for i in arr:
    for j in range(i, K+1):
        dp[j] += dp[j-i]

print(dp[K])
