# 8 3
# 1 5 4 6 2 1 3 7
# [1, 1, 2, 3, 4, 5, 6, 7]
import sys

input = sys.stdin.readline


def check(target):
    global arr, M

    now_min = now_max = arr[0]
    count = 1

    for i in range(len(arr)):
        now_min = min(now_min, arr[i])
        now_max = max(now_max, arr[i])

        if now_max - now_min > target:
            count += 1
            now_max = now_min = arr[i]

    # print("count", count, target)
    return M >= count


N, M = map(int, input().split())

arr = list(map(int, input().split()))

left = 0
right = max(arr)

result = 0

while left <= right:
    mid = (left + right) // 2

    if check(mid):
        right = mid - 1
        result = mid
        # print(result)
    else:
        left = mid + 1


print(result)
