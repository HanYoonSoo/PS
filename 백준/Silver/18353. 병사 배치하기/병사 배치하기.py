import sys

inpit = sys.stdin.readline

N = int(input().rstrip())

number = list(map(int, input().split()))

number.reverse()

dp = [1] * N

for i in range(1, N):
    for j in range(0, i):
        if number[i] > number[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(N - max(dp))