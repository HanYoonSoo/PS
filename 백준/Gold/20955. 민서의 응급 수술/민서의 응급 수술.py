import sys

input = sys.stdin.readline

N, M = map(int, input().split())

parent = list(range(N+1))

result = 0

def find_parent(parent, p):
    if parent[p] == p:
        return p

    parent[p] = find_parent(parent, parent[p])

    return parent[p]

def union(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for _ in range(M):
    a, b = map(int, input().split())
    if find_parent(parent, a) == find_parent(parent, b):
        result += 1
    union(parent, a, b)

idx = 1

for i in range(2, N+1):
    if find_parent(parent, i) != find_parent(parent, idx):
        result += 1
        union(parent, i, idx)
        idx = i

print(result)
