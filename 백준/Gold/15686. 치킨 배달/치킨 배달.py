import sys
from itertools import combinations

input = sys.stdin.readline

N, M = map(int, input().split())

graph = []

house = []
store = []

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        if temp[j] == 1:
            house.append((i, j))
        elif temp[j] == 2:
            store.append((i, j))

    graph.append(temp)

result = sys.maxsize

for combs in combinations(store, M):
    temp = 0
    for house_x, house_y in house:
        store_distance = sys.maxsize
        for store_x, store_y in combs:
            store_distance = min(abs(house_x - store_x) + abs(house_y-store_y), store_distance)
        temp += store_distance

    result = min(result, temp)

print(result)


