import math
cnt = int(input())

for i in range(cnt):
  
  x1,y1,r1,x2,y2,r2 = map(int,input().split())

  d = math.sqrt(pow(x2-x1,2)+pow(y2-y1,2))

  if r1>r2:
    if r1-r2<d<r1+r2:
      print(2)
    elif r1+r2==d or r1-r2==d:
      print(1)
    elif r1+r2<d or d<r1-r2:
      print(0)
    else:
      print(-1)
  if r2>r1:
    if r2-r1<d<r2+r1:
      print(2)
    elif r2+r1==d or r2-r1==d:
      print(1)
    elif r2+r1<d or d<r2-r1:
      print(0)
    else:
      print(-1)
  if r2==r1:
    if x1==x2 and y1==y2:
      print(-1)
    else:
      if r2-r1<d<r2+r1:
        print(2)
      elif r2+r1==d or r2-r1==d:
        print(1)
      elif r2+r1<d or d<r2-r1:
        print(0)
    
