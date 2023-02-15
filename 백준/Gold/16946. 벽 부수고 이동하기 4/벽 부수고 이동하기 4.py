import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(x, y):

    result = 1

    visited[x][y] = True
    zero[x][y] = num

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < N and 0 <= ny < M and graph[nx][ny] == 0 and not visited[nx][ny]:
            result += dfs(nx, ny)

    return result

N, M = map(int, input().split())

graph = []
zero = [[0] * M for _ in range(N)]
group = {}
group[0] = 0

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

for _ in range(N):
    graph.append(list(map(int, input().rstrip())))

visited = [[False] * M for _ in range(N)]

num = 1
for i in range(N):
    for j in range(M):
        if graph[i][j] == 0 and not visited[i][j]:
            count = dfs(i, j)
            group[num] = count

            num += 1

for i in range(N):
    for j in range(M):
        group_list = set()

        if graph[i][j] == 1:
            for dir in range(4):
                nx = i + dx[dir]
                ny = j + dy[dir]

                if 0 <= nx < N and 0 <= ny < M:
                    group_list.add(zero[nx][ny])

            for region in group_list:
                graph[i][j] += group[region]
                graph[i][j] %= 10

for g in graph:
    print(*g, sep='')





# 입력
# 5 5
# 01111
# 10100
# 01000
# 10111
# 00000
#
# 출력
# 03166
# 40700
# 04000
# 80222
# 00000