import sys

V = int(sys.stdin.readline())

def dfs(start , w):
    for v_i, v_w in graph[start]:
        if distance[v_i] == -1:
            distance[v_i] = v_w + w
            dfs(v_i, distance[v_i])


graph = [[] * (V+1) for _ in range(V+1)]

for _ in range(V):
    temp = list(map(int, sys.stdin.readline().split()))
    v = temp[0]
    temp.pop(0)
    while temp[0] != -1:
        graph[v].append((temp[0], temp[1]))
        temp.pop(0)
        temp.pop(0)

distance = [-1] * (V+1)
distance[1] = 0

dfs(1, 0)

maxi = distance.index(max(distance))

distance = [-1] * (V + 1)
distance[maxi] = 0

dfs(maxi, 0)

print(max(distance))





