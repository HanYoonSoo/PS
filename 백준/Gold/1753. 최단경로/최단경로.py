import sys
import heapq

INF = sys.maxsize
V, E = map(int, sys.stdin.readline().split())
start = int(sys.stdin.readline().rstrip())
distance = [INF] * (V+1)

heap = []
graph = [[] for _ in range(V+1)]

for _ in range(E):
    v1, v2, w = map(int, sys.stdin.readline().split())
    graph[v1].append((w, v2))


def dijkstra(start):
    distance[start] = 0

    heapq.heappush(heap, (0, start))

    while heap:
        now_w, now_v = heapq.heappop(heap)

        if distance[now_v] < now_w:
            continue

        for next_w, next_v in graph[now_v]:
            totalW = now_w + next_w

            if distance[next_v] > totalW:
                distance[next_v] = totalW
                heapq.heappush(heap, (totalW, next_v))

dijkstra(start)

for i in range(1, V+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])



dijkstra(start)









