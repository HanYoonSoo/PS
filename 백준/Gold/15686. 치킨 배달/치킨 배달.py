import sys
from itertools import combinations
input = sys.stdin.readline

def solution(grid, m):
    n = len(grid)

    house = []
    store = []

    for i in range(n):
        for j in range(n):
            if grid[i][j] == 1:
                house.append((i, j))
            elif grid[i][j] == 2:
                store.append((i, j))

    result = sys.maxsize

    for chicken in combinations(store, m):
        chicken_distance = 0

        for house_x, house_y in house:
            temp = sys.maxsize
            for chicken_x, chicken_y in chicken:
                temp = min(temp, abs(house_x - chicken_x) + abs(house_y - chicken_y))
            chicken_distance += temp

        result = min(result, chicken_distance)

    return result

n, m = map(int, input().split())

grid = []

for _ in range(n):
    grid.append(list(map(int, input().split())))

print(solution(grid, m))

