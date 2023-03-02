def dfs(start, visited, graph):
    visited[start] = True
    
    for i in range(1, len(graph)):
        if graph[start][i] == 1:
            if not visited[i]:
                dfs(i, visited, graph)
                    
def solution(n, wires):
    graph = [[0] * (n+1) for _ in range(n+1)]
    
    for a, b in wires:
        graph[a][b] = 1
        graph[b][a] = 1
    
    result = 1e9
    
    for a, b in wires:
        graph[a][b] = 0
        graph[b][a] = 0
        
        visited = [False] * (n+1)
        
        temp = []
        arr = []
        for i in range(1, n+1):
            if not visited[i]:
                dfs(i, visited, graph)
                arr.append(i)
                temp.append(visited.count(True))
        
        if len(temp) > 1:
            temp[1] = temp[1] - temp[0]
            result = min(result, abs(temp[1] - temp[0]))
            
        graph[a][b] = 1
        graph[b][a] = 1
    
    return result
        
        
                