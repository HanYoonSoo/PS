import sys
import heapq

input = sys.stdin.readline

N = int(input().rstrip())

homework = []

for _ in range(N):
    deadline, food = map(int, input().split())
    homework.append((deadline, food))

homework.sort()

heap = []

for i in homework:
    heapq.heappush(heap, i[1])

    if i[0] < len(heap):
        heapq.heappop(heap)

print(sum(heap))