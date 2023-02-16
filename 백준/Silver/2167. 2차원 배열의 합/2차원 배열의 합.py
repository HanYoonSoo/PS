import sys

input = sys.stdin.readline

N, M = map(int, input().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, input().split())))

T = int(input())

for _ in range(T):
    x1, y1, x2, y2 = map(int, input().split())

    result = 0
    for i in range(x1-1, x2):
        for j in range(y1-1, y2):
            result += graph[i][j]

    print(result)
