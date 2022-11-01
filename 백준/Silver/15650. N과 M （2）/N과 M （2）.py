n,m = list(map(int,input().split()))
 
s = []
 
def dfs():
    a=1
    if len(s)==m:
        print(' '.join(map(str,s)))
        return
    
    for i in range(1,n+1):
        if i not in s:
            if len(s) > 0:
              for j in s:
                if j > i:
                  a  = 0
                  break
            if a==0:
              a= 1
              continue
            
            s.append(i)
            dfs()
            s.pop()
 
dfs()