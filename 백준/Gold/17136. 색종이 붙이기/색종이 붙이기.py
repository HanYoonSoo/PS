import sys

graph = []

for _ in range(10):
    graph.append(list(map(int, sys.stdin.readline().split())))

paper = [0, 5, 5, 5, 5, 5]
result = 1000000000

def dfs(x, y, count):

    global result
    if x >= 9 and y > 9:
        result = min(result, count)
        return

    if count >= result:
        return

    if y > 9:
        dfs(x + 1, 0, count)
        return

    if graph[x][y] == 1:
        for i in range(5, 0, -1):
            if paper[i] > 0 and isAttach(x, y, i):
                attach(x, y, i, 0)
                paper[i] -= 1
                dfs(x, y+1, count + 1)
                paper[i] += 1
                attach(x, y, i, 1)
    else:
        dfs(x, y + 1, count)

def isAttach(x, y, size):
    for i in range(x, x + size):
        for j in range(y, y + size):
            if i >= 10 or j >= 10:
                return False

            if graph[i][j] != 1:
                return False

    return True

def attach(x, y, size, compare):
    for i in range(x, x + size):
        for j in range(y, y + size):
            graph[i][j] = compare

dfs(0, 0, 0)

if result == 1000000000:
    print(-1)
else:
    print(result)