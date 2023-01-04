import sys
import heapq

N, K = map(int, sys.stdin.readline().split())

jew = []
bag = []

for _ in range(N):
    jew.append(list(map(int, sys.stdin.readline().split())))

for _ in range(K):
    bag.append(int(sys.stdin.readline()))

jew.sort()
bag.sort()

temp = []
answer = 0

for b in bag:
    # print(b)
    while jew and b >= jew[0][0]:
        heapq.heappush(temp, -heapq.heappop(jew)[1])
     #   print(jew)
    if temp:
        answer -= heapq.heappop(temp)

print(answer)