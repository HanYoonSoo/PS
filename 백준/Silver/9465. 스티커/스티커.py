import sys

input = sys.stdin.readline

T = int(input().rstrip())

for i in range(T):
    arr = []
    N = int(input().rstrip())
    arr.append(list(map(int, input().split())))
    arr.append(list(map(int, input().split())))
    dp = [[0] * N for _ in range(2)]

    dp[0][0] = arr[0][0]
    dp[1][0] = arr[1][0]

    if N == 1:
        print(max(dp[0][0], dp[1][0]))
        continue

    dp[1][1] = arr[0][0] + arr[1][1]
    dp[0][1] = arr[1][0] + arr[0][1]

    if N == 2:
        print(max(dp[1][1], dp[0][1]))
        continue

    for i in range(2, N):
        dp[0][i] = max(dp[1][i-2], dp[1][i-1]) + arr[0][i]
        dp[1][i] = max(dp[0][i-2], dp[0][i-1]) + arr[1][i]

    print(max(dp[0][-1], dp[1][-1]))

