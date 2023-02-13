import sys

input = sys.stdin.readline

graph = []

N = int(input())
graph = [[sys.maxsize] * (N+1) for _ in range(N+1)]

M = int(input())

for _ in range(M):
    a, b, w = map(int, input().split())
    if graph[a][b] > w:
        graph[a][b] = w

def floyd():
    for k in range(1, N+1):
        for i in range(1, N+1):
            for j in range(1, N+1):
                if i == j:
                    graph[i][j] = 0
                else:
                    if graph[i][j] > graph[i][k] + graph[k][j]:
                        graph[i][j] = graph[i][k] + graph[k][j]
floyd()

for i in range(1, len(graph)):
    for j in range(1, N+1):
        if graph[i][j] == sys.maxsize:
            print(0, end = ' ')
        else:
            print(graph[i][j], end = ' ')
    print()