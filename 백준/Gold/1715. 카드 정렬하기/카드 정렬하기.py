import heapq
import sys

input = sys.stdin.readline

N = int(input().rstrip())

card = []

for _ in range(N):
    heapq.heappush(card, int(input().rstrip()))

total = 0
while len(card) > 1:
    a = heapq.heappop(card)
    b = heapq.heappop(card)
    total += a + b
    heapq.heappush(card, a + b)

print(total)

