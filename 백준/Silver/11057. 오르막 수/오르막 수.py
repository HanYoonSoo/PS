# 0 1 2 3 4 5 6 7 8 9
# 1 1 1 1 1 1 1 1 1 1
# 0 1 2 3 4 5 6 7 8 9
# 1 2 3 4 5 6 7 8 9 10

import sys

input = sys.stdin.readline

N = int(input().rstrip())

dp = [1] * 10

for i in range(N-1):
    for j in range(1, 10):
        dp[j] = dp[j-1] + dp[j]

print(sum(dp) % 10007)
