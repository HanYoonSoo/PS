import sys

K, N, F = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

for _ in range(F):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in range(1, N):
    graph[i].sort()

def dfs(x, result, visited):
    visited[x] = True
    result.append(x)

    if len(result) == K:
        if startV in graph[x]:
            for v in result:
                print(v)
            exit(0)
        return
    for v in graph[x]:
        if not visited[v]:
            compare = True

            for j in result:
                if v not in graph[j]:
                    compare = False
                    break

            if compare:
                dfs(v, result, visited)
                if len(result) != 0:
                    result.pop()

for i in range(1, N+1):
    visited = [False] * (N+1)
    result = []
    if not visited[i]:
        startV = i
        dfs(i, result, visited)

print(-1)