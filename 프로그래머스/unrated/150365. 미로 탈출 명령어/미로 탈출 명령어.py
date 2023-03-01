from collections import deque
import heapq
def move(idx):
    if idx == 0:
        return 'd'
    elif idx == 1:
        return 'l'
    elif idx == 2:
        return 'r'
    else:
        return 'u'
    
def bfs(x, y, k, n, m, r, c, result):
    dx = [1, 0, 0, -1]
    dy = [0, -1, 1, 0]
    
    q = deque()
    q.append((x, y, ''))
    visited = [[0] * (m + 1) for _ in range(n+1)]
    
    visited[x][y] = 0
    
    while q:
        x, y, path = q.popleft()

        if x == r and y == c and visited[x][y] == k:
            return path
        
        if visited[x][y] > k:
            break
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 1 <= nx <= n and 1 <= ny <= m:
                if abs(nx - r) + abs(ny - c) + visited[x][y] +1 > k:
                    continue
                q.append((nx, ny, path + move(i)))
                visited[nx][ny] = visited[x][y] + 1
                break
    
    return ''
        
def solution(n, m, x, y, r, c, k):
    graph = [[0] * (m + 1) for _ in range(n+1)]
    
    graph[r][c] = 1
    
    result = []
    result = bfs(x, y, k, n, m, r, c, result)
    
    
    if result == '':
        return 'impossible'
    else:
        return result
    
    