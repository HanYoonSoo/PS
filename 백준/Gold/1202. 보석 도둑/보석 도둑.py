import sys
import heapq

input = sys.stdin.readline

N, K = map(int, input().split())

jew = []
bag = []

for _ in range(N):
    a, b = map(int, input().split())
    jew.append((a, b))

for _ in range(K):
    bag.append(int(input().rstrip()))

jew.sort()
bag.sort()

heap = []

result = 0
for b in bag:
    while jew and b >= jew[0][0]:
        heapq.heappush(heap, -heapq.heappop(jew)[1])

    if heap:
        result -= heapq.heappop(heap)

print(result)
