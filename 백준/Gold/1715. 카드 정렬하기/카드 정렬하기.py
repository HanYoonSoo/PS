import heapq

N = int(input())

arr = []

for _ in range(N):
    heapq.heappush(arr, int(input()))

result = 0

while len(arr) > 1:
    min1 = heapq.heappop(arr)
    min2 = heapq.heappop(arr)

    heapq.heappush(arr, min1 + min2)
    result += min1 + min2

print(result)

