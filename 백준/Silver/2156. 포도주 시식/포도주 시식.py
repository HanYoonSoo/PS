N = int(input())

dp = [0] * (N+1)
cal = [0] * (N+1)

maximum = 0

for i in range(1,N+1):
  dp[i] = int(input())

cal[1] = dp[1]
if N > 1:
  cal[2] = dp[1] + dp[2]
  
  for i in range(3,N+1):
    cal[i] = max(cal[i-1],cal[i-2]+dp[i],dp[i-1]+dp[i]+cal[i-3])
  

print(max(cal))
