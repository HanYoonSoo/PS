import sys

input = sys.stdin.readline

N = int(input().rstrip())
graph = [[0] * 101 for _ in range(101)]

for _ in range(N):
    x, y = map(int, input().split())

    for i in range(y, y + 10):
        for j in range(x, x + 10):
            graph[i][j] = 1

count = 0
for i in range(1, 101):
    count += graph[i].count(1)

print(count)


