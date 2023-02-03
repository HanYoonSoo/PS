N = int(input())

W = [0]

for _ in range(N):
    W.append(int(input()))

sum = 0

for i in W:
    sum += i

dp = [[0] * (sum+1) for _ in range(N+1)]

for i in range(1, len(W)):
    dp[i][W[i]] = 1
    for j in range(1, sum+1):
        if j > W[i]:
            for idx in range(1, i):
                if dp[idx][j-W[i]] > 0:
                    dp[i][j] = dp[idx][j-W[i]] + 1

minW = sum
result = sum

for i in range(1, N+1):
    for j in range(1, sum+1):
        if dp[i][j] == N // 2:
            if abs(2*j - sum) < minW:
                minW = abs(2 * j - sum)
                result = j

print(min(result, abs(result-sum)))
print(max(result, abs(result-sum)))

