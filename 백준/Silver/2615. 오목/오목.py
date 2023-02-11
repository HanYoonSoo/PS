import sys

input = sys.stdin.readline

graph = []

for _ in range(19):
    graph.append(list(map(int, input().split())))

def bfs(a, b):
    dx = [1, 1, 0, -1]  # 하(↓), 우하(⬊), 우(➞), 우상(⬈)
    dy = [0, 1, 1, 1]
    for i in range(4):
        count = 1
        x = a
        y = b
        while 0 <= x + dx[i] < 19 and 0 <= y + dy[i] < 19 and graph[x + dx[i]][y + dy[i]] == graph[a][b]:
            x = x + dx[i]
            y = y + dy[i]

            count += 1

            # print(x,y,count)

        if count == 5:
            if 0 <= x + dx[i] < 19 and 0 <= y + dy[i] < 19 and graph[x + dx[i]][y + dy[i]] == graph[x][y]:
                break
            if 0 <= a - dx[i] < 19 and 0 <= b - dy[i] < 19 and graph[a - dx[i]][b - dy[i]] == graph[a][b]:
                break

            return True

    return False



for i in range(19):
    for j in range(19):
        if graph[i][j] == 1 or graph[i][j] == 2:
            if bfs(i, j):
                print(graph[i][j])
                print(i+1, j+1)
                exit(0)

print(0)