def count_sum_combinations(N, K):
    dp = [[0] * (N + 1) for _ in range(K + 1)]  # 동적 계획법을 위한 2차원 배열 생성

    for i in range(K + 1):
        dp[i][0] = 1  # 합이 0인 경우는 1가지 방법으로 가능

    for i in range(1, K + 1):
        for j in range(1, N + 1):
            dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000000  # 1,000,000,000으로 나눈 나머지 계산

    return dp[K][N]

# 입력 받기
N, K = map(int, input().split())

# 결과 출력
result = count_sum_combinations(N, K)
print(result)
