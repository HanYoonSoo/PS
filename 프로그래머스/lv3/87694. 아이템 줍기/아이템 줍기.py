from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    graph = [[5] * 102 for _ in range(102)]
    
    for r in rectangle:
        x1, y1, x2, y2 = map(lambda x : x * 2, r)
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if x1 < i < x2 and y1 < j < y2:
                    graph[i][j] = 0
                elif graph[i][j] != 0:
                    graph[i][j] = 1
    
    q = deque()
    q.append((characterX * 2, characterY * 2))
    visited = [[0] * 102 for _ in range(102)]
    visited[characterX * 2][characterY * 2] = 1
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    

    while q:
        x, y = q.popleft()
        
        if x == itemX * 2 and y == itemY * 2:
            return (visited[x][y] - 1) // 2
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 1 <= nx < 102 and 1 <= ny < 102 and visited[nx][ny] == 0 and graph[nx][ny] == 1:
                q.append((nx, ny))
                visited[nx][ny] = visited[x][y] + 1
        
    