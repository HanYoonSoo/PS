num = int(input())
result = num
count = 2

while result != 1:
  if result%count==0:
    print(count)
    result /= count
    count=2
  else:
    count +=1