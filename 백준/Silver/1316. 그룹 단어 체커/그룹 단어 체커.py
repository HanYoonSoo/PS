a = int(input())
count = a
for i in range(a):
  str = input()
  for j in range(len(str)-1):
    if str[j] == str[j+1]:
      continue
    elif str[j] in str[j+1:]:
      count -=1
      break

print(count)

