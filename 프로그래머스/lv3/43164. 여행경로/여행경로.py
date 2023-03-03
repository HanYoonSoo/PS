from collections import deque
    
def solution(tickets):
    q = deque()
    q.append(('ICN', ['ICN'], []))
    
    result = []
    
    while q:
        airport, path, used = q.popleft()
        
        if len(used) == len(tickets):
            result.append(path)
            
        for idx, ticket in enumerate(tickets):
            if airport == ticket[0] and idx not in used:
                q.append((ticket[1], path + [ticket[1]], used + [idx]))
                
    result.sort()
    
    return result[0]