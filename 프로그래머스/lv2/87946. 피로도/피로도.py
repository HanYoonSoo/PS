from itertools import permutations

def solution(k, dungeons):
    length = len(dungeons)
    
    result = 0
    for per in permutations(dungeons, length):
        count = 0
        tired = k
        
        for i in range(length):
            if tired >= per[i][0]:
                tired -= per[i][1]
                count += 1
        
        result = max(result, count)
    
    return result
        
    
    