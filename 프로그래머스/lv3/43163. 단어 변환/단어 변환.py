from collections import deque

def check(str1, str2):
    str1 = list(str1)
    str2 = list(str2)
    
    count = 0
    for i in range(len(str1)):
        if str1[i] != str2[i]:
            count += 1
    
    if count >= 2:
        return False
    else:
        return True
        
def solution(begin, target, words):
    str_dict = {}
    str_dict[begin] = 0
    
    q = deque()
    q.append(begin)
    
    while q:
        temp_str = q.popleft()
        distance = str_dict[temp_str]
        
        if temp_str == target:
            return distance
        
        if distance > len(words):
            break
        for i in range(len(words)):
            if check(temp_str, words[i]):
                if words[i] not in q:
                    q.append(words[i])
                    str_dict[words[i]] = distance + 1
    return 0