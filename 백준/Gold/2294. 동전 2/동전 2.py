import sys

N, K = map(int, sys.stdin.readline().split())

coin = []
dp = [0 for _ in range(K+1)]

for _ in range(N):
    coin.append(int(sys.stdin.readline()))

for i in range(1, K+1):
    temp = []
    for c in coin:
        if c <= i and dp[i-c] != -1:
            temp.append(dp[i-c])
    if not temp:
        dp[i] = -1
    else:
        dp[i] = min(temp) + 1

print(dp[K])



