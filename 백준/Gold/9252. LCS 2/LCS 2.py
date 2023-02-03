import sys

A = [''] + list(sys.stdin.readline().rstrip())
B = [''] + list(sys.stdin.readline().rstrip())

LCS = [[''] * len(B) for _ in range(len(A))]

for i in range(1, len(A)):
    for j in range(1, len(B)):
        if A[i] == B[j]:
            LCS[i][j] = LCS[i-1][j-1] + A[i]
        else:
            if len(LCS[i-1][j]) >= len(LCS[i][j-1]):
                LCS[i][j] = LCS[i-1][j]
            else:
                LCS[i][j] = LCS[i][j-1]

print(len(LCS[-1][-1]))
print(LCS[-1][-1])
