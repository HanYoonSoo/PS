import sys
n = int(sys.stdin.readline())
real = False

for _ in range(n):
    n_call = int(sys.stdin.readline())
    
    # 전화번호 목록 - 문자열
    cl = list(sys.stdin.readline().rstrip() for _ in range(n_call))
    cl.sort()
    
    for i in range(len(cl)-1):
    # 문자열로 정렬되었으므로 바로 옆만 비교
        if cl[i] in cl[i+1][:len(cl[i])]:
            print("NO")
            real = True
            break
    if real == False:
        print("YES")
    real = False