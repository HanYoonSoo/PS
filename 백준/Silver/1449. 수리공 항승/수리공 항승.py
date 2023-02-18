N, L = map(int, input().split())

arr = list(map(int, input().split()))

arr.sort()

start = arr[0]

count = 1

for location in arr[1:]:
    if location in range(start, start + L):
        continue
    else:
        start = location
        count += 1

print(count)

