def solution(N, stages):
    stages_count = [0] * (N+1)
    
    for num in stages:
        if num == N + 1:
            continue
        stages_count[num] += 1
    
    temp = []
    length = len(stages)
    
    for i in range(1, N+1):
        if stages_count[i] == 0:
            temp.append((0, i))
        else:
            temp.append((stages_count[i] / length, i))
        
        length -= stages_count[i]
    
    temp.sort(key = lambda x : (-x[0], x[1]))
    
    result = []
    
    for i in range(len(temp)):
        result.append(temp[i][1])
    
    return result
    
    
    
    