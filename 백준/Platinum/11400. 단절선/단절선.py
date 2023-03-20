import sys
sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

def dfs(vertex, parent):
    global count
    order[vertex] = count
    count += 1

    compare = order[vertex]

    for next in graph[vertex]:
        if next == parent:
            continue

        if order[next] == 0:
            minValue = dfs(next, vertex)

            if minValue > order[vertex]:
                if next > vertex:
                    result.append([vertex, next])
                else:
                    result.append([next, vertex])

            compare = min(compare, minValue)
        else:
            compare = min(compare, order[next])

    return compare

V, E = map(int, input().split())

graph = [[] for _ in range(V + 1)]

for _ in range(E):
    a, b = map(int, input().split())

    graph[a].append(b)
    graph[b].append(a)

count = 1

order = [0] * (V + 1)
result = []

for i in range(1, V + 1):
    if order[i] == 0:
        dfs(i, 0)

result.sort()

print(len(result))
for i in range(len(result)):
    print(result[i][0], result[i][1])


