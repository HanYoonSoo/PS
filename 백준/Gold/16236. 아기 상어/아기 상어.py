from collections import deque
import copy

class Node:
    def __init__(self, x, y, dist):
        self.x = x
        self.y = y
        self.dist = dist

N = int(input())

graph = []
q = deque()

for i in range(N):
    graph.append(list(map(int, input().split())))
    if 9 in graph[i]:
        q.append(Node(i, graph[i].index(9), 0))
        graph[i][graph[i].index(9)] = 0

size = 2
time = 0
eat = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while True:
    fish = []
    dist = [[0] * N for _ in range(N)]
    while q:
        node = q.popleft()

        for i in range(4):
            nx = node.x + dx[i]
            ny = node.y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and dist[nx][ny] == 0 and graph[nx][ny] <= size:
                dist[nx][ny] = node.dist + 1
                q.append(Node(nx, ny, dist[nx][ny]))

                if 1 <= graph[nx][ny] <= 6 and graph[nx][ny] < size:
                    fish.append(Node(nx, ny, dist[nx][ny]))

    if len(fish) == 0:
        print(time)
        exit(0)

    currentFish = fish[0]

    for i in range(1, len(fish)):
        if currentFish.dist > fish[i].dist:
            currentFish = fish[i]
        elif currentFish.dist == fish[i].dist:
            if currentFish.x > fish[i].x:
                currentFish = fish[i]
            elif currentFish.x == fish[i].x:
                if currentFish.y > fish[i].y:
                    currentFish = fish[i]

    time += currentFish.dist
    eat += 1

    if eat == size:
        size += 1
        eat = 0

    graph[currentFish.x][currentFish.y] = 0
    q.append(Node(currentFish.x, currentFish.y, 0))



