import sys

input = sys.stdin.readline

N = int(input().rstrip())
M = int(input().rstrip())

graph = []

for i in range(N):
    graph.append(list(map(int, input().split())))

plan = list(map(int, input().split()))

parent = list(range(N))

def find_parent(p):
    if parent[p] == p:
        return p

    parent[p] = find_parent(parent[p])

    return parent[p]

def union(a, b):
    a = find_parent(a)
    b = find_parent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(N):
    for j in range(N):
        if i != j:
            if graph[i][j] == 1:
                if find_parent(i) != find_parent(j):
                    union(i, j)

for i in range(len(plan) - 1):
    if find_parent(plan[i]-1) != find_parent(plan[i+1]-1):
        print("NO")
        exit(0)

print("YES")