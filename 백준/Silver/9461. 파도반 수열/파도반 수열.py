import sys
T = int(sys.stdin.readline())

P = [0] * 101

P[1] = 1
P[2] = 1
P[3] = 1

for i in range(T):
  N = int(sys.stdin.readline())
  for i in range(4,N+1):
    P[i] = P[i-2]+P[i-3]

  print(P[N])
  