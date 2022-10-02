a = ['c=','c-','dz=','d-','lj','nj','s=','z=']

str = input()
count = 0
for i in a:
  if str.count(i)>0:
    count +=str.count(i)

print(str.__len__()-count)