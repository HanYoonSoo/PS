def solution(s):
    result = len(s)
    
    for i in range(1, len(s) // 2 + 1):
        tmp, idx = '', 0
        while idx < len(s):
            c = s[idx:idx+i]
            n = 1
            while c == s[idx+i:idx+i+i]:
                idx += i
                n += 1
            if n != 1:
                tmp += str(n) + c
            else:
                tmp += c
            idx = idx + i
        result = min(result, len(tmp))
    return result
    
            
        