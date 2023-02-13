# 1   2   3   4
# 1   1   2   3
#
#
# 10000
# 10001
# 10010
# 10100
# 10101

N = int(input())

dp = [0] * (N+1)

if N <= 2:
    print(1)
    exit(0)

dp[1] = 1
dp[2] = 1

for i in range(3, N+1):
    dp[i] = dp[i-1] + dp[i-2]

print(dp[N])


