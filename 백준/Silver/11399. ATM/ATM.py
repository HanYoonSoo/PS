# 5
# 3 1 4 3 2

N = int(input())
number = list(map(int, input().split()))

number.sort()

dp = [0] * N

if N >= 2:
    dp[0] = number[0]
    dp[1] = number[0] + number[1]

    for i in range(2, N):
        dp[i] = dp[i-1] + number[i]
else:
    print(number[N-1])
    exit(0)
    
print(sum(dp))