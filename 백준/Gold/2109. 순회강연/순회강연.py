import heapq

N=int(input())
col=[]
for i in range(N):
  col.append(list(map(int, input().split())))

col.sort(key=lambda x: x[1])
minHeap=[]
for i in col:
  heapq.heappush(minHeap, i[0])
  if (len(minHeap)>i[1]):
    heapq.heappop(minHeap)

print(sum(minHeap))