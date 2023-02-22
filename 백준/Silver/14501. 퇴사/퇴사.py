import sys

input = sys.stdin.readline

N = int(input().rstrip())

T = []
P = []

for _ in range(N):
    a, b = map(int,input().split())
    T.append(a)
    P.append(b)

dp = [0] * (N+1)

maxValue = 0

for i in range(N-1, -1, -1):
    time = i + T[i]

    if time <= N:
        dp[i] = max(P[i] + dp[time], maxValue)
        maxValue = dp[i]
    else:
        dp[i] = maxValue

print(maxValue)