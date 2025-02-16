from itertools import combinations

def solution(n, q, ans):
    list = [i for i in range(1, n + 1)]
    
    for i in range(len(ans)):
        if ans[i] == 0:
            for num in q[i]:
                if num in list:
                    list.remove(num)
    
    answer = 0
    
    for c in combinations(list, 5): 
        for i in range(len(q)):
            cnt = 0
            for j in q[i]:     
                if j in c:
                    cnt += 1
            if cnt != ans[i]:
                break  
        else:   
            answer += 1
    
    return answer