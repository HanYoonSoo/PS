import sys

input = sys.stdin.readline

N = int(input())

graph = []

teacher = []
for i in range(N):
    temp = list(input().split())
    for j in range(N):
        if temp[j] == 'T':
            teacher.append((i, j))
    graph.append(temp)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def check(x, y):

    for i in range(4):
        nx = x
        ny = y
        while 0 <= nx + dx[i] < N and 0 <= ny + dy[i] < N:
            nx += dx[i]
            ny += dy[i]

            if graph[nx][ny] == 'S':
                return False
            if graph[nx][ny] == 'O':
                break
    return True

def dfs(start, depth):
    if depth == 3:
        for x, y in teacher:
            if not check(x, y):
                return

        print("YES")
        exit(0)
        return

    for i in range(start, N * N):
        r = i // N
        c = i % N

        if graph[r][c] == 'X':
            graph[r][c] = 'O'
            dfs(i, depth + 1)
            graph[r][c] = 'X'

dfs(0, 0)
print('NO')