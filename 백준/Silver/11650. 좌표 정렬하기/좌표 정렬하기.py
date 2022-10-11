import sys

num = int(sys.stdin.readline())
number = []
for i in range(num):
  number.append(list(map(int,sys.stdin.readline().split())))

number.sort()

for i in range(len(number)):
  print(number[i][0], number[i][1])