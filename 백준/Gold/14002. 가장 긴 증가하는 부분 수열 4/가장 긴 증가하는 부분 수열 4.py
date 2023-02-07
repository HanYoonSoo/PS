import sys

N = int(sys.stdin.readline())

arr = list(map(int ,sys.stdin.readline().split()))

dp = [1] * N

for i in range(len(arr)):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)

maxIdx = max(dp)

result = []

for i in range(len(dp)-1, -1, -1):
    if dp[i] == maxIdx:
        result.append(arr[i])
        maxIdx -= 1

result.reverse()

print(len(result))
print(*result)


