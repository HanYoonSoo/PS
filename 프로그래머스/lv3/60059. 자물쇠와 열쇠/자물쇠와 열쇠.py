# 1 2 3
# 4 5 6
# 7 8 9
def rotate_90_degree_key(key):
    result = [[0] * len(key) for _ in range(len(key))]
    n = len(key)
    
    for i in range(n):
        for j in range(n):
            result[j][n-i-1] = key[i][j]
    
    return result

def check(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    
    return True
            
def solution(key, lock):
    n = len(lock)
    m = len(key)
    
    new_lock = [[0] * (n * 3) for _ in range(n * 3)]
    
    for i in range(n):
        for j in range(n):
            new_lock[i + n][j + n] = lock[i][j]
            
    for i in range(4):
        key = rotate_90_degree_key(key)
        for x in range(n * 2):
            for y in range(n * 2):
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] += key[i][j]
                
                if check(new_lock):
                    return True
                
                for i in range(m):
                    for j in range(m):
                        new_lock[x + i][y + j] -= key[i][j]
    
    return False
                
                
                        