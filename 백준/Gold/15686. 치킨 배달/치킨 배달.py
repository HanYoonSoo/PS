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
for chicken in combinations(store, M):
    chick_distance = 0
    for hx, hy in house:
        temp = sys.maxsize
        for cx, cy in chicken:
            temp = min(abs(cx-hx) + abs(cy - hy), temp)
        chick_distance += temp
    result = min(result, chick_distance)

print(result)
