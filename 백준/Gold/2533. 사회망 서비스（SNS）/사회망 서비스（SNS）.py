import sys
sys.setrecursionlimit(10 ** 6)

input = sys.stdin.readline

N = int(input().rstrip())

dp = [[0, 0] for _ in range(N+1)]

graph = [[] for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N+1)

def dfs(start):
    visited[start] = True
    if len(graph[start]) == 0:
        dp[start][0] = 0
        dp[start][1] = 1
    else:
        for v in graph[start]:
            if not visited[v]:
                dfs(v)
                dp[start][1] += min(dp[v][0], dp[v][1])
                dp[start][0] += dp[v][1]
        dp[start][1] += 1
dfs(1)

print(min(dp[1][0], dp[1][1]))
