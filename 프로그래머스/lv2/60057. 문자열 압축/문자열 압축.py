def solution(s):
    result = len(s)
    
    for i in range(1, len(s)//2 + 1):
        idx = 0
        tmp = ''
        while idx < len(s):
            c = s[idx:idx+i]
            n = 1
            while c == s[idx+i:idx+i+i]:
                n += 1
                idx = idx + i
            if n != 1:
                tmp += str(n) + c
            else:
                tmp += c
            
            idx = idx + i
        result = min(result, len(tmp))
    
    return result
            
        