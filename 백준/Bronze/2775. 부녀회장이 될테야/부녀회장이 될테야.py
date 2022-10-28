N= int(input())

for i in range(N):
  k = int(input())
  n = int(input())

  f = [i for i in range(1,n+1)]
  for j in range(k):
    for i in range(n-1):
      f[i+1] = f[i+1]+f[i]

  print(f[-1])
