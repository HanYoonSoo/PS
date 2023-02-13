import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())

graph = [[] for _ in range(V+1)]

for _ in range(E):
    a, b, w = map(int, input().split())
    graph[a].append((w, b))
    graph[b].append((w, a))

def prim():
    visited = [False] * (V+1)
    heap = [[0, 1]]
    count = 0
    result = 0

    while heap:
        if count == V:
            return result

        w, vertex = heapq.heappop(heap)

        if not visited[vertex]:
            visited[vertex] = True
            count += 1
            result += w
            for info in graph[vertex]:
                heapq.heappush(heap, info)


print(prim())