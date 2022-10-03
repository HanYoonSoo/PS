num = int(input())

movie = 666
cnt = 0
while True:
  if cnt == num:
    movie -= 1
    break
  if '666' in str(movie):
    cnt+=1
  movie +=1

print(movie)