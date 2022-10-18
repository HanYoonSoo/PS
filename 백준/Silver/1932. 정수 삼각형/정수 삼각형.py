import sys

n = int(sys.stdin.readline())

c = []
for i in range(n):
  c.append(list(map(int,sys.stdin.readline().rstrip().split())))

for i in range(1,n):
  for j in range(i+1):
    if j ==0:
      c[i][0] += c[i-1][0]
    if j!=0 and j!=i:
      c[i][j] += max(c[i-1][j-1],c[i-1][j])
    if j==i:
      c[i][j] += c[i-1][j-1]

print(max(c[n-1]))
  