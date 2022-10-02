a = int(input())

cnt = 1
Y = a//5

while True:
  compare = a-Y*5
  if compare%3 == 0:
    print(Y+compare//3)
    break
  else:
    if Y > 0:
      Y -=1
    cnt +=1
    if 3*cnt > a:
      print(-1)
      break