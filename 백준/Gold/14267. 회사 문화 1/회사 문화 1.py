import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(start, w):
    dist[start] += w

    for next in tree[start]:
        dfs(next, dist[start])

N, M = map(int, input().split())

tree = [[] for _ in range(N + 1)]
dist = [0] * (N + 1)

arr = list(map(int, input().split()))

for i in range(1, len(arr)):
    tree[arr[i]].append(i + 1)

for _ in range(M):
    a, b = map(int, input().split())

    dist[a] += b

dfs(1, 0)

print(*dist[1:], sep=' ')
