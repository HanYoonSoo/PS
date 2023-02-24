def balanced_index(p):
    count = 0
    
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        
        if count == 0:
            return i
def check(u):
    count = 0
    for i in range(len(u)):
        if u[i] == '(':
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    
    return True

def solution(p):
    if p == '':
        return p
    
    index = balanced_index(p)
    u = p[:index+1]
    v = p[index+1:]
    
    if check(u):
        return u + solution(v)
    
    temp = '('
    temp += solution(v)
    temp += ')'
    u = list(u[1:-1])
    
    for i in range(len(u)):
        if u[i] == '(':
            u[i] = ')'
        else:
            u[i] = '('
    
    return temp + ''.join(u)
    