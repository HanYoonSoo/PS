import sys

minimum = 1e9
maximum = -1e9
N = int(sys.stdin.readline())

num=list(map(int,sys.stdin.readline().rstrip().split()))

cal=list(map(int,sys.stdin.readline().rstrip().split()))

def calculator(cnt,total,plus,minus,multiply,divide):
  global maximum,minimum,N
  
  if cnt == N:
    maximum = max(total,maximum)
    minimum = min(total,minimum)
    return


  if plus:
    calculator(cnt+1,total+num[cnt],plus-1,minus,multiply,divide)
  if minus:
    calculator(cnt+1,total-num[cnt],plus,minus-1,multiply,divide)
  if multiply:
    calculator(cnt+1,total*num[cnt],plus,minus,multiply-1,divide)
  if divide:
    calculator(cnt+1,int(total/num[cnt]),plus,minus,multiply,divide-1)

calculator(1,num[0],cal[0],cal[1],cal[2],cal[3])
print(maximum)
print(minimum)
    
  
  
    
  



