import sys

input = sys.stdin.readline

N, C = map(int, input().split())

arr = []

for _ in range(N):
    arr.append(int(input().rstrip()))

arr.sort()

start = 1
end = arr[-1] - arr[0]

result = 0
while start <= end:
    count = 1
    mid = (start + end) // 2
    value = arr[0]

    for i in range(1, len(arr)):
        if value + mid <= arr[i]:
            value = arr[i]
            count += 1

    if count >= C:
        start = mid + 1
        result = max(result, mid)
    else:
        end = mid - 1

print(result)


