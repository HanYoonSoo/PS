import heapq
import sys

N = int(sys.stdin.readline().rstrip())

heap = []

count = 0
for _ in range(N):
    n = int(sys.stdin.readline().rstrip())
    if n == 0:
        if heap:
            print(-heapq.heappop(heap))
        else:
            print(0)
    else:
        heapq.heappush(heap, -n)
