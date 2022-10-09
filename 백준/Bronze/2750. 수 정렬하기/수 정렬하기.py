num = int(input())
number = []
for i in range(num):
  n = int(input())
  number.append(n)

number.sort()

for i in number:
  print(i)