def solution(scores):
    wonho = scores[0].copy()
    
    scores.sort(key = lambda x : (-x[0], x[1]))
    
    minValue = scores[0][1]
    
    count = 0
    
    check = []
    for i in range(len(scores)):
        if minValue > scores[i][1]:
            continue
        elif minValue <= scores[i][1]:
            minValue = scores[i][1]
            if sum(wonho) < sum(scores[i]):
                count += 1
                
        check.append(scores[i])        
    
    if wonho not in check:
        return -1
    
    return count + 1

# 3 2
# 3 2
# 2 1
# 2 2
# 1 4