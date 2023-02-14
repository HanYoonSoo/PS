import sys

input = sys.stdin.readline

V = int(input().rstrip())

E = int(input().rstrip())

graph = [[] for _ in range(V+1)]

for _ in range(E):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

def dfs(start):
    visited[start] = True

    for v in graph[start]:
        if not visited[v]:
            dfs(v)

visited = [False] * (V+1)

dfs(1)

print(sum(visited)-1)
