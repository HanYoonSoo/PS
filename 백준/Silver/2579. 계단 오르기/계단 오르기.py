import sys

N = int(sys.stdin.readline())

s = [0 for _ in range(301)]
cal = [0 for _ in range(301)]

for i in range(N):
  s[i] = int(sys.stdin.readline())

cal[0] = s[0]
cal[1] = s[0] + s[1]
cal[2] = max(s[0] + s[2],s[1]+s[2])

for i in range(3,N):
  cal[i] = max(cal[i-3]+s[i-1]+s[i],cal[i-2]+s[i])

print(cal[N-1])
  