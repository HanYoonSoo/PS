import sys
import heapq

N = int(sys.stdin.readline())

course = []

for _ in range(N):
    p, d = map(int, sys.stdin.readline().split())

    course.append([p, d])

course.sort(key=lambda x : x[1])

minHeap = []
for c in course:
    heapq.heappush(minHeap, c[0])

    if len(minHeap) > c[1]:
        heapq.heappop(minHeap)

print(sum(minHeap))