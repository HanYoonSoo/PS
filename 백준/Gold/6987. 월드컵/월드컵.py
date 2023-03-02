import sys
from itertools import combinations

input = sys.stdin.readline

game = list(combinations(range(6), 2))

def dfs(depth):
    global result
    if depth == 15:
        result = 1

        for sub in cup:
            if sub.count(0) != 3:
                result = 0
                break

        return

    a, b = game[depth]

    for x, y in ((0, 2), (1, 1), (2, 0)):
        if cup[a][x] > 0 and cup[b][y] > 0:
            cup[a][x] -= 1
            cup[b][y] -= 1
            dfs(depth + 1)
            cup[a][x] += 1
            cup[b][y] += 1

for i in range(4):
    data = list(map(int, input().split()))

    cup = []
    for i in range(0, 16, 3):
        cup.append(data[i:i+3])
    result = 0
    dfs(0)
    print(result)



