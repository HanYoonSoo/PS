import heapq
import sys

N = int(sys.stdin.readline())

leftHeap = []
rightHeap = []

for i in range(N):
    if len(leftHeap) == len(rightHeap):
        heapq.heappush(leftHeap, -int(sys.stdin.readline()))
    else:
        heapq.heappush(rightHeap, int(sys.stdin.readline()))

    if rightHeap and -leftHeap[0] > rightHeap[0]:
        leftNum = heapq.heappop(leftHeap)
        rightNum = heapq.heappop(rightHeap)

        heapq.heappush(leftHeap, -rightNum)
        heapq.heappush(rightHeap, -leftNum)

    print(-leftHeap[0])
# 1, 5, 2, 10, -99, 7, 5
# -99 1 2 5 5 7 10
# 1 1 2 2 2 2 5
#
# 1 1 5 2 2 2 2 10

