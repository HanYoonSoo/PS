import sys

input = sys.stdin.readline

N, K, Q = map(int, input().split())

line = list(map(int, input().split()))
answer = list(map(int, input().split()))

dp = [0] * (N + 1)

if line[0] == K:
    dp[1] = 0
else:
    dp[1] = 1

length = 2

for i in range(1, N):
    if line[i] == K:
        dp[i+1] = dp[i]
    elif line[i-1] == K:
        dp[i+1] = dp[i] + 1
        length = 2
    else:
        dp[i+1] = dp[i] + length
        length += 1

for i in range(Q):
    print(dp[answer[i]])