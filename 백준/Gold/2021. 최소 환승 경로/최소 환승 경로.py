import sys
from collections import deque

N, L = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
line = [[] for _ in range(L)]

for i in range(L):
    temp = list(map(int, sys.stdin.readline().split()))[:-1]
    for j in range(len(temp)):
        graph[temp[j]].append(i)
        line[i].append(temp[j])

def bfs(start, end):
    if start == end:
        return 0

    q = deque()

    visit = [-1] * (N+1)
    visit_line = [False] * L

    visit[start] = 0

    for temp_line in graph[start]:
        q.append((start, temp_line))
        visit_line[temp_line] = True

    while q:
        cur_node, cur_line = q.popleft()

        for node in line[cur_line]:
            if visit[node] == -1:
                if node == end:
                    return visit[cur_node]
                visit[node] = visit[cur_node] + 1

                for connected_line in graph[node]:
                    if not visit_line[connected_line]:
                        q.append((node, connected_line))

    return -1

start, end = map(int, sys.stdin.readline().split())

print(bfs(start, end))

