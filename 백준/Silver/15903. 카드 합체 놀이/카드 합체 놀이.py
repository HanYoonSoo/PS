import heapq

n, m = map(int, input().split())

heap = []

arr = list(map(int, input().split()))

for i in range(n):
    heapq.heappush(heap, arr[i])

for _ in range(m):
    x = heapq.heappop(heap)
    y = heapq.heappop(heap)

    heapq.heappush(heap, x + y)
    heapq.heappush(heap, x + y)

print(sum(heap))

