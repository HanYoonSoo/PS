num = int(input())
number = []
while num > 0:
  number.append(num%10)
  num = num//10

number.sort()

for i in range(len(number)-1,-1,-1):
  print(number[i], end="")