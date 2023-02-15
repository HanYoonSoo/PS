import sys

input = sys.stdin.readline

V, E = map(int, input().split())

graph = [[] for _ in range(V)]
visited = [False] * (V+1)

for _ in range(E):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

def dfs(start, depth):
    visited[start] = True
    if depth == 4:
        print(1)
        exit(0)

    for v in graph[start]:
        if not visited[v]:
            visited[v] = True
            dfs(v, depth + 1)
            visited[v] = False

for i in range(V):
    dfs(i, 0)
    visited[i] = False

print(0)


