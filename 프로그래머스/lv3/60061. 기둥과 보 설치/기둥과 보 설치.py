def possible(result):
    
    for x, y, a in result:
        if a == 0:
            if y == 0 or (x - 1, y, 1) in result or (x, y, 1) in result or (x, y - 1, 0) in result:
                continue
            return False
        elif a == 1:
            if (x, y - 1, 0) in result or (x + 1, y - 1, 0) in result or ((x-1, y, 1) in result and (x + 1, y, 1) in result):
                continue
            return False
    
    return True

def solution(n, build_frame):
    result = []
    
    for x, y, a, b in build_frame:
        if b == 1:
            result.append((x, y, a))
            if not possible(result):
                result.remove((x, y, a))
        elif b == 0:
            result.remove((x, y, a))
            if not possible(result):
                result.append((x, y, a))
    
    return sorted(result)
            