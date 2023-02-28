import sys

input = sys.stdin.readline

N, M = map(int, input().split())

bigger = [[] for _ in range(N+1)]
smaller = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())

    bigger[a].append(b)
    smaller[b].append(a)

def dfs(arr, start):
    global count
    visited[i] = True

    for v in arr[start]:
        if not visited[v]:
            visited[v] = True
            count += 1

            dfs(arr, v)

mid = (N+1) / 2

result = 0
for i in range(1, N+1):
    visited = [False] * (N+1)
    count = 0
    dfs(bigger, i)
    if count >= mid:
        result += 1

    count = 0
    visited = [False] * (N+1)
    dfs(smaller, i)
    if count >= mid:
        result += 1

print(result)
