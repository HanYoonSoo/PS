import sys

def dfs(start, w):
    for v, v_w in graph[start]:
        if distance[v] == -1:
            distance[v] = w + v_w
            dfs(v, distance[v])

V = int(sys.stdin.readline())

graph = [[] for _ in range(V+1)]

for _ in range(V):
    temp = list(map(int, sys.stdin.readline().split()))[:-1]

    v = temp[0]

    for i in range(1, len(temp), 2):
        graph[v].append((temp[i], temp[i+1]))

distance = [-1] * (V+1)
distance[1] = 0

dfs(1, 0)

maxIdx = distance.index(max(distance))

distance = [-1] * (V+1)
distance[maxIdx] = 0

dfs(maxIdx, 0)
print(max(distance))

