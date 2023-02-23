import sys

input = sys.stdin.readline

num_gate = int(input().rstrip())
num_plane = int(input().rstrip())

planes = []

for _ in range(num_plane):
    planes.append(int(input().rstrip()))

parent = [i for i in range(num_gate + 1)]

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

count = 0

for i in range(num_plane):
    root = find_parent(parent, planes[i])

    if root == 0:
        break

    union(parent, root, root - 1)
    count += 1

print(count)