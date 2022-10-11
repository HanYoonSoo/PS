import sys

num = int(sys.stdin.readline())
str = []
for i in range(num):
  str.append(sys.stdin.readline().strip())
  
set_lst = set(str)
str = list(set_lst)
str.sort()
str.sort(key=len)
for i in str:
  print(i)