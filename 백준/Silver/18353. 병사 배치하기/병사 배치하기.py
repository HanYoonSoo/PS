import sys

input = sys.stdin.readline

N = int(input().rstrip())

arr = list(map(int, input().split()))

arr.reverse()

dp = [1] * N
# 4 2 5 8 4 11 15
for i in range(1, N):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(N - max(dp))

