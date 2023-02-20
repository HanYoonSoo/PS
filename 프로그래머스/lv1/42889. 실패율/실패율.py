def solution(N, stages):
    stage_human = [0] * (N+1)
    
    for stage in stages:
        if stage == N + 1:
            continue
        stage_human[stage] += 1
    
    temp = [(1, stage_human[1] / len(stages))]
    
    length = len(stages) - stage_human[1]
    
    for i in range(2, N + 1):
        if stage_human[i] == 0:
            temp.append((i, 0))
        else:
            temp.append((i, stage_human[i] / length))
        length -= stage_human[i]
    
    temp.sort(key = lambda x : (-x[1], x[0]))
    
    result = []
    for i in range(len(temp)):
        result.append(temp[i][0])
    
    return result
    
    