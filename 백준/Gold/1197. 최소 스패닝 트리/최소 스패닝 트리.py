import sys
import heapq

INF = 1e9

input = sys.stdin.readline

def prim():
    V, E = map(int, input().split())

    graph = [[] for _ in range(V+1)]

    for _ in range(E):
        a, b, w = map(int, input().split())

        graph[a].append((w, b))
        graph[b].append((w, a))

    visited = [False] * (V+1)

    heap = [(0, 1)]

    result = 0
    count = 0

    while heap:
        if count == V:
            print(result)
            return

        w, node = heapq.heappop(heap)

        if not visited[node]:
            result += w
            count += 1
            visited[node] = True

            for v_w, v in graph[node]:
                heapq.heappush(heap, (v_w, v))

#########################################
def find_parent(parent, p):
    if parent[p] == p:
        return p

    parent[p] = find_parent(parent, parent[p])

    return parent[p]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def kruskal():
    V, E = map(int, input().split())

    parent = [i for i in range(V+1)]
    edges = []

    for _ in range(E):
        a, b, c = map(int, input().split())
        edges.append((a, b, c))

    edges.sort(key = lambda x : x[2])

    result = 0

    for a, b, c in edges:
        if find_parent(parent, a) != find_parent(parent, b):
            union(parent, a, b)
            result += c

    print(result)

kruskal()
#prim()