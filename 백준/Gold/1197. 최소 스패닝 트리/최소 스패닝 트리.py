import sys
import heapq

input = sys.stdin.readline

V, E = map(int, input().split())

edges = []
for _ in range(E):
    edges.append(list(map(int, input().split())))

edges.sort(key=lambda x : x[2])

parent = [i for i in range(0, V+1)]

def get_parent(v):
    if parent[v] == v:
        return v

    parent[v] = get_parent(parent[v])
    return parent[v]

def same_parent(a, b):
    if get_parent(a) == get_parent(b):
        return True
    else:
        return False

def union_parent(a, b):
    a = get_parent(a)
    b = get_parent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

def kruskal():
    result = 0
    for a, b, dist in edges:
        if not same_parent(a, b):
            union_parent(a, b)
            result += dist

    return result


print(kruskal())
