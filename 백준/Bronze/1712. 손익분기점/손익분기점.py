ocost, pcost, value = map(int,input().split())

if pcost>=value:
  print(-1)
else:
  print(int(ocost/(value-pcost)+1))
