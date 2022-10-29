num = int(input())
han = 0
if num<100:
  print(num)
else:
  han = 99
  number = []
  for i in range(100,num+1):
    number = list(str(i))
    if (int(number[0])+int(number[2]))/2 == int(number[1]):
      han += 1 
  print(han)

