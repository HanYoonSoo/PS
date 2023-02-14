import sys
from collections import deque

input = sys.stdin.readline

N = int(input())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

def dfs(x, y, dir):
    global count

    if x == N-1 and y == N-1:
        count += 1
        return

    if x + 1 < N and y + 1 < N:
        if graph[x+1][y] == 0 and graph[x][y+1]  == 0 and graph[x+1][y+1] == 0:
            dfs(x+1, y+1, 2)

    if dir == 0 or dir == 2:
        if y + 1 < N:
            if graph[x][y+1] == 0:
                dfs(x, y + 1, 0)

    if dir == 1 or dir == 2:
        if x + 1 < N:
            if graph[x+1][y] == 0:
                dfs(x + 1, y, 1)



count = 0

dfs(0, 1, 0)

print(count)