import sys

num = int(sys.stdin.readline())
str = []
for i in range(num):
    str.append(list(sys.stdin.readline().split()))
  

str.sort(key=lambda x:int(x[0]))

for i in range(len(str)):
  print(str[i][0], str[i][1])