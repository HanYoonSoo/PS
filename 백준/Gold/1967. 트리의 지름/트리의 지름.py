import sys
sys.setrecursionlimit(10 ** 6)
def dfs(start, w):
    for v, v_w in graph[start]:
        if distance[v] == -1:
            distance[v] = w + v_w
            dfs(v, distance[v])

N = int(sys.stdin.readline())

graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    v1, v2, w = map(int,sys.stdin.readline().split())

    graph[v1].append((v2, w))
    graph[v2].append((v1, w))

distance = [-1] * (N+1)
distance[1] = 0

dfs(1, 0)

maxIdx = distance.index(max(distance))
maxLen = max(distance)

distance = [-1] * (N+1)
distance[maxIdx] = 0

dfs(maxIdx, 0)
maxLen = max(distance)

print(maxLen)
