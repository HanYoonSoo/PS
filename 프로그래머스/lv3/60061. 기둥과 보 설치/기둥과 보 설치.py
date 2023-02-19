def possible(result):
    for frame in result:
        x, y, struct = frame
        
        if struct == 0:
            if y == 0 or [x-1, y, 1] in result or [x, y, 1] in result or [x, y - 1, 0] in result:
                continue
            return False
        if struct == 1:
            if [x, y-1, 0] in result or [x+1, y-1, 0] in result or ([x-1, y, 1] in result and [x+1, y, 1] in result):
                continue
            return False
    return True
def solution(n, build_frame):
    result = []
    
    for frame in build_frame:
        x, y, struct, operate = frame
        if operate == 1:
            result.append([x, y, struct])
            if not possible(result):
                result.remove([x, y, struct])
        if operate == 0:
            result.remove([x, y, struct])
            if not possible(result):
                result.append([x, y, struct])
    
    return sorted(result)