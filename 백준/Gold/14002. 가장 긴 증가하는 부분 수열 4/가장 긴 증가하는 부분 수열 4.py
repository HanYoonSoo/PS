import sys
import copy

N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
dp = [1] * N

for i in range(N):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

result = []
maxN = max(dp)
print(maxN)

for i in range(N-1, -1, -1):
    if maxN == dp[i]:
        result.append(arr[i])
        maxN -= 1

result.reverse()

print(*result)




