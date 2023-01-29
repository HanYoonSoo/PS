import sys

T = int(sys.stdin.readline())

for _ in range(T):
    N, M = map(int, sys.stdin.readline().split())
    arr = list(map(int, sys.stdin.readline().split()))
    idx = list(range(len(arr)))

    idx[M] = "target"

    count = 0

    while True:
        if arr[0] == max(arr):
            count += 1

            if idx[0] == "target":
                print(count)
                break
            else:
                arr.pop(0)
                idx.pop(0)
        else:
            arr.append(arr.pop(0))
            idx.append(idx.pop(0))

