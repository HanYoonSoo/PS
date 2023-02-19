import sys

input = sys.stdin.readline

N, M = map(int, input().split())

A = []
B = []

def change(x, y, A):
    if len(A) < 3:
        print(-1)
        exit(0)

    for i in range(x, x + 3):
        for j in range(y, y + 3):
            if A[i][j] == 1:
                A[i][j] = 0
            else:
                A[i][j] = 1


for i in range(N):
    A.append(list(map(int, input().rstrip())))

for i in range(N):
    B.append(list(map(int, input().rstrip())))

count = 0
for i in range(N-2):
    for j in range(M-2):
        if A[i][j] != B[i][j]:
            change(i, j, A)
            count += 1

for i in range(N):
    for j in range(M):
        if A[i][j] != B[i][j]:
            print(-1)
            exit(0)

print(count)