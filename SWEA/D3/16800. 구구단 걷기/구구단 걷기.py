import math

T = int(input().rstrip())
for test_case in range(1, T + 1):
    N = int(input())

    result = 0
    for j in range(1, int(N ** 0.5) + 1):
        if N % j == 0:
            result = (j-1) + (N // j) - 1

    print(f'#{test_case}', result)
