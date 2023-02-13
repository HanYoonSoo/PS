import sys

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    arr = []

    N = int(input().rstrip())
    for _ in range(N):
        a, b = map(int, input().split())

        arr.append((a, b))

    arr.sort()

    count = 1

    min1 = arr[0][1]

    for i in range(1, len(arr)):
        if min1 > arr[i][1]:
            min1 = arr[i][1]
            count += 1

    print(count)