import sys

num = int(sys.stdin.readline())
number = []
for i in range(num):
  number.append(list(map(int,sys.stdin.readline().split())))

number.sort(key=lambda x:(x[1],x[0]))

for i in range(len(number)):
  print(number[i][0], number[i][1])