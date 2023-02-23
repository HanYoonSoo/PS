import sys
input = sys.stdin.readline

N = int(input().rstrip())

parent = [i for i in range(N)]
graph = []
planet = []

for i in range(N):
    x, y, z = map(int, input().split())
    planet.append((x, y, z, i))

for i in range(3):
    planet.sort(key = lambda x : x[i])
    for j in range(1, N):
        graph.append((planet[j-1][3], planet[j][3], abs(planet[j-1][i] - planet[j][i])))

graph.sort(key = lambda x : x[2])

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

result = 0
for a, b, c in graph:
    if find_parent(parent, a) != find_parent(parent, b):
        union(parent, a, b)
        result += c

print(result)

# 3
# 1 1 1
# 2 3 9
# -1 9 5