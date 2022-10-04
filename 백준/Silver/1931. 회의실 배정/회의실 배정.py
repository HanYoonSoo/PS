import sys
N = int(sys.stdin.readline())

time = []
for i in range(N):
  time.append(list(map(int,sys.stdin.readline().rstrip().split())))

time.sort(key = lambda x:x[0])
time.sort(key = lambda x:x[1])



sd = 0
cnt = 0

for i in range(len(time)):
  if sd <= time[i][0]:
    sd = time[i][1]
    cnt +=1
    
    
print(cnt)
      
  
