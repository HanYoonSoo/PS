a = int(input())

for i in range(a):
  num, str = input().split()
  sen = ''
  for s in str:
    sen += int(num) * s
  print(sen)