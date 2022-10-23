x,y,w,h = map(int,input().split())

x1 = w-x
y1 = h-y

square = [x,y,x1,y1]

min = min(square)
print(min)