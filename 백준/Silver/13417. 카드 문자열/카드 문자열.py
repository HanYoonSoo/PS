import sys

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    N = int(input().rstrip())
    A = list(map(str, input().split()))

    result = [A[0]]

    for i in range(1, len(A)):
        left = result[0]

        if A[i] <= left:
            result.insert(0, A[i])
        else:
            result.append(A[i])

    print(''.join(result))