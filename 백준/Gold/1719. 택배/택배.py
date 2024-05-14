import sys

# 입력)
# 6 10
# 1 2 2
# 1 3 1
# 2 4 5
# 2 5 3
# 2 6 7
# 3 4 4
# 3 5 6
# 3 6 7
# 4 6 4
# 5 6 2

input = sys.stdin.readline

N, M = map(int, input().split())

grid = [[sys.maxsize for _ in range(N + 1)] for _ in range(N + 1)]
path = [[j for j in range(0, N + 1)] for _ in range(N + 1)]

for _ in range(M):
    a, b, w = map(int, input().split())
    grid[b][a] = grid[a][b] = min(grid[a][b], w)

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            if grid[i][k] == sys.maxsize or grid[k][j] == sys.maxsize:
                continue
            if grid[i][j] > grid[i][k] + grid[k][j]:
                grid[i][j] = grid[i][k] + grid[k][j]
                path[i][j] = path[i][k]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            print("-", end = " ")
        else:
            print(path[i][j], end = " ")
    print()



