import sys
from collections import deque

class Node:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def bfs(a, b, num):
    global space
    global side
    global maxSize

    q = deque()
    q.append(Node(a, b))
    grid[a][b] = num
    set_collect = set()
    count = 1

    while q:
        node = q.popleft()
        x = node.x
        y = node.y

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if (graph[x][y] & dir[i]) == 0 and grid[nx][ny] == 0:
                    q.append(Node(nx, ny))
                    grid[nx][ny] = num
                    count += 1

                if grid[nx][ny] != 0 and grid[nx][ny] != num:
                    set_collect.add(grid[nx][ny])

    space.append(count)
    side[num] = set_collect
    maxSize = max(maxSize, count)

M, N = map(int, sys.stdin.readline().split())

graph = []

for _ in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

grid = [[0] * M for _ in range(N)]

num = 1
room = 0
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]
dir = [1, 2, 4, 8]
space = []
side = {}
maxSize = 0

for i in range(N):
    for j in range(M):
        if grid[i][j] == 0:
            bfs(i, j, num)
            num += 1
            room += 1

print(room)
print(maxSize)

sum = 0
for i in range(1, room+1):
    if side[i]:
        for j in side[i]:
            sum = max(space[i-1] + space[j-1], sum)

print(sum)


