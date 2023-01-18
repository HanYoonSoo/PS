N = list(map(int, input()))

length = len(N)

dp = [0 for _ in range(length+1)]

if N[0] == 0:
    print("0")
else:
    N = [0] + N
    dp[0] = dp[1] = 1
    for i in range(2, length+1):
        if N[i] > 0:
            dp[i] += dp[i-1]
        temp = N[i-1] * 10 + N[i]
        if temp >= 10 and temp <= 26:
            dp[i] += dp[i-2]

    print(dp[length] % 1000000)

