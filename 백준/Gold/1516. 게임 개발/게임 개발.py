import sys
from collections import deque
N = int(sys.stdin.readline())

time = [0] * (N+1)
building = [[] for _ in range(N+1)]
indegree = [0] * (N+1)

for i in range(1,N+1):
    temp = list(map(int, sys.stdin.readline().split()))[:-1]
    time[i] = temp[0]
    building_prior = temp[1:]

    for j in building_prior:
        building[j].append(i)
        indegree[i] += 1

result = [0] * (N+1)
q = deque()

for i in range(1, N+1):
    if indegree[i] == 0:
        q.append(i)

while q:
    now = q.popleft()
    result[now] += time[now]

    for v in building[now]:
        result[v] = max(result[v], result[now])
        indegree[v] -= 1
        if indegree[v] == 0:
            q.append(v)

for i in range(1, N+1):
    print(result[i])


