import sys


def dfs(start):
    global visited, check, compare
    if compare:
        return
    visited[start] = True
    check.append(start)

    if K == len(check):

        for i in range(len(check)):
            print(check[i])
        compare = True
        return
    else:
        for i in range(start + 1, N+1):
            if not visited[i]:
                flag = True
                for j in check:
                    if not graph[i][j]:
                        flag = False
                        break

                if flag:
                    dfs(i)
                    if len(check) != 0:
                        check.pop()



K, N, F = map(int, sys.stdin.readline().split())

graph = [[False] * (N+1) for _ in range(N+1)]

for _ in range(F):
    v1, v2 = map(int, sys.stdin.readline().split())
    graph[v1][v2] = True
    graph[v2][v1] = True



for i in range(1, N+1):
    compare = False
    check = []
    visited = [False] * (N + 1)

    dfs(i)
    if compare:
        break
if not compare:
    print(-1)
