from itertools import permutations
from copy import deepcopy
import sys

N, M, K = map(int, sys.stdin.readline().split())
grid = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
rcs = [list(map(int, sys.stdin.readline().split())) for _ in range(K)]

result = 1000000000

for p in permutations(rcs, K):
    copyGrid = deepcopy(grid)
    for r, c, s in p:
        r -= 1
        c -= 1
        for n in range(s, 0, -1):
            temp = copyGrid[r-n][c+n]
            copyGrid[r-n][c-n+1:c+n+1] = copyGrid[r-n][c-n:c+n]
            for row in range(r-n, r+n):
                copyGrid[row][c-n] = copyGrid[row+1][c-n]
            copyGrid[r+n][c-n:c+n] = copyGrid[r+n][c-n+1:c+n+1]
            for row in range(r+n, r-n, -1):
                copyGrid[row][c+n] = copyGrid[row-1][c+n]
            copyGrid[r-n+1][c+n] = temp

    for row in copyGrid:
        result = min(result, sum(row))

print(result)


