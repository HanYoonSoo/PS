import sys
input = sys.stdin.readline

# 10211
t = int(input())

for _ in range(t):
    n = int(input())
    li = list(map(int, input().split()))
    dp = [0] * n
    dp[0] = li[0]
    for i in range(1, n):
        dp[i] = max(dp[i-1]+li[i], li[i])
    print(max(dp))