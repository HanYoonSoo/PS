import sys

input = sys.stdin.readline

graph = []

N, M, B = map(int, input().split())
result = sys.maxsize
block = 0
for _ in range(N):
    graph.append(list(map(int, input().split())))

for num in range(257):
    minNum = 0
    maxNum = 0

    for i in range(N):
        for j in range(M):
            if graph[i][j] >= num:
                maxNum += graph[i][j] - num
            else:
                minNum += num - graph[i][j]

    if maxNum + B >= minNum:
        if maxNum * 2 + minNum <= result:
            result = maxNum * 2 + minNum
            block = num

print(result, block)

