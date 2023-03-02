from collections import deque

def solution(n, roads, sources, destination):
    graph = [[] for _ in range(n+1)]
    for a, b in roads:
        graph[a].append(b)
        graph[b].append(a)
    
    dist = [-1] * (n + 1)
    
    dist[destination] = 0
    
    q = deque()
    q.append(destination)
    
    visited = [False] * (n+1)
    visited[destination] = True
    
    while q:
        node = q.popleft()
        
        for v in graph[node]:
            if not visited[v]:
                visited[v] = True
                dist[v] = dist[node] + 1
                q.append(v)
    
    result = []
    
    for s in sources:
        result.append(dist[s])
                
    return result