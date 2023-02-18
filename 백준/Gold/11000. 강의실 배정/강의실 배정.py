import heapq
N = int(input())

arr = []

heap = []

for i in range(N):
    a, b = map(int, input().split())
    arr.append((a, b))

arr.sort(key=lambda x: x[0])

heapq.heappush(heap, arr[0][1])

for i in range(1, len(arr)):
    if arr[i][0] < heap[0]:
        heapq.heappush(heap, arr[i][1])
    else:
        heapq.heappop(heap)
        heapq.heappush(heap, arr[i][1])

print(len(heap))
