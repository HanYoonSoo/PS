import sys

N = int(sys.stdin.readline())

arr = list(map(int, sys.stdin.readline().split()))

M = int(sys.stdin.readline())

check = [[False] * N for _ in range(N)]

for diag in range(N):
    for i in range(N-diag):
        j = i + diag
        check[i][j] = arr[i] == arr[j] and (diag <= 1 or check[i+1][j-1])
for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    if check[a-1][b-1]:
        print(1)
    else:
        print(0)