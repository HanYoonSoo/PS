def solution(m, n, puddles):
    dp = [[0] * (m + 1) for _ in range(n+1)]
    
    for y, x in puddles:
        dp[x][y] = -1
    
    if dp[1][2] != -1:
        dp[1][2] = 1
    
    if dp[2][1] != -1:
        dp[2][1] = 1
        
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            if dp[i][j] == -1:
                continue
            
            if dp[i][j-1] != -1:
                dp[i][j] = dp[i][j] + dp[i][j-1]
            
            if dp[i-1][j] != -1:
                dp[i][j] = dp[i][j] + dp[i-1][j]
    
    return dp[n][m] % 1000000007