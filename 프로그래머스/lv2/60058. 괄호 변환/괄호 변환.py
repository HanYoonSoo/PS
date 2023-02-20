def balanced_index(p):
    count = 0
    
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return i
def check_balanced(p):
    count = 0
    
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
        
        return True
    
def solution(p):
    if p == '':
        return ''
    
    idx = balanced_index(p)
    u = p[:idx+1]
    v = p[idx+1:]
    
    if check_balanced(u):
        result = u + solution(v)
        return result
    else:
        temp = '('
        temp += solution(v)
        temp += ')'
        u = u[1:-1]
        for i in range(len(u)):
            if u[i] == '(':
                temp += ')'
            else:
                temp += '('
        
        return temp
        
    return result