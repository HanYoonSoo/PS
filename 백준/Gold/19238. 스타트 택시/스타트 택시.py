import sys
from collections import deque

N, M, oil = map(int, input().split())

grid = []

for i in range(N):
    grid.append(list(map(int, input().split())))

customer = {}
start_x, start_y = map(int, input().split())

for i in range(M):
    a, b, c, d = map(int, input().split())

    customer[(a-1, b-1)] = (c-1, d-1)

q = deque()
q.append((start_x-1, start_y-1, 0))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

humanCount = M

def check(hx, hy, target_x, target_y):
    temp = deque()
    temp_visited = [[False] * N for _ in range(N)]

    temp.append((hx, hy, 0))
    temp_visited[hx][hy] = True

    while temp:
        x, y, count = temp.popleft()

        if x == target_x and y == target_y:
            return count
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not temp_visited[nx][ny] and grid[nx][ny] != 1:
                temp_visited[nx][ny] = True
                temp.append((nx, ny, count + 1))

    return -1

while oil > 0:
    visited = [[False] * N for _ in range(N)]
    human = []

    while q:
        x, y, count = q.popleft()

        if (x, y) in customer:
            if (x, y, count) not in human:
                human.append((x, y, count))
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and grid[nx][ny] != 1:
                q.append((nx, ny, count + 1))
                visited[nx][ny] = True
                if (nx, ny) in customer:
                    if (nx, ny, count + 1) not in human:
                        human.append((nx, ny, count + 1))

    if len(human) == 0:
        if humanCount == 0:
            print(oil)
            exit(0)
        else:
            print(-1)
            exit(0)

    human.sort(key = lambda x : (x[2], x[0], x[1]))

    hx, hy, distance = human[0][0], human[0][1], human[0][2]

    #print(hx, hy, distance)
    target_x, target_y = customer[(hx, hy)]

    compare = check(hx, hy, target_x, target_y)
    if compare == -1:
        print(-1)
        exit(0)

    customer.pop((hx, hy))

    oil -= distance
    #print(oil)
    if oil > 0:
        if oil >= (abs(hx - target_x) + abs(hy-target_y)):
            oil = oil - compare + compare * 2
            #print(oil)
        else:
            print(-1)
            exit(0)

    q.append((target_x, target_y, 0))
    humanCount -= 1

if humanCount != 0 and oil <= 0:
    print(-1)









