import sys
num = int(sys.stdin.readline())

list = []

for i in range(num):
  list.append(int(sys.stdin.readline()))

list.sort()

for i in list:
  print(i)