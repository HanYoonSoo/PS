import sys

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    V = int(input().rstrip())

    parent = [0] * (V+1)

    for _ in range(V-1):
        a, b = map(int, input().split())

        parent[b] = a

    a_parent = []
    b_parent = []

    a, b = map(int, input().split())

    a_parent.append(a)
    b_parent.append(b)

    while parent[a]:
        a_parent.append(parent[a])
        a = parent[a]

    while parent[b]:
        b_parent.append(parent[b])
        b = parent[b]

    a_length = len(a_parent) - 1
    b_length = len(b_parent) - 1

    while a_parent[a_length] == b_parent[b_length]:
        a_length -= 1
        b_length -= 1

    print(a_parent[a_length + 1])


