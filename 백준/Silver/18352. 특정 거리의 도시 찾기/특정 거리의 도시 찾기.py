import sys
from collections import deque

input = sys.stdin.readline

N, M, K, X = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())

    graph[a].append(b)
def bfs(start):
    global result
    q = deque()
    q.append((start, 0))
    visited = [False] * (N+1)
    visited[start] = True

    while q:
        now, count = q.popleft()

        if count == K:
            result.append(now)
            continue
        for v in graph[now]:
            if not visited[v]:
                visited[v] = True
                q.append((v, count + 1))

result = []
bfs(X)

result.sort()
if len(result) != 0:
    print('\n'.join(map(str, result)))
else:
    print(-1)