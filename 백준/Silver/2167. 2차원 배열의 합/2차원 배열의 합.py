import sys

N, M = map(int, sys.stdin.readline().split())
graph = []

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

T = int(sys.stdin.readline())

for _ in range(T):
    i, j, x, y = map(int, sys.stdin.readline().split())

    result = 0
    for a in range(i-1, x):
        for b in range(j-1, y):
            result += graph[a][b]

    print(result)
