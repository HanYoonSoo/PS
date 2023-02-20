import sys
from collections import deque

input = sys.stdin.readline

N, K = map(int, input().split())

virus = [[] for _ in range(K+1)]

graph = []

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        if temp[j] != 0:
            virus[temp[j]].append((i, j))
    graph.append(temp)

#print(virus[1])
S, X, Y = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, num, temp_virus):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == 0:
            graph[nx][ny] = num
            temp_virus.append((nx, ny))


for i in range(S):
    for j in range(1, K + 1):
        temp_virus = []
        for x, y in virus[j]:
            bfs(x, y, j, temp_virus)
        virus[j] = temp_virus

if graph[X-1][Y-1] == 0:
    print(0)
else:
    print(graph[X-1][Y-1])
