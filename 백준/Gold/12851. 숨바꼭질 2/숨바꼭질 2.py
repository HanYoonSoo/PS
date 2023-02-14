import sys
from collections import deque

N, K = map(int, input().split())

visited = [0] * 100001

def bfs():
    q = deque()
    q.append(N)

    result = 0
    result_count = 0

    while q:
        x = q.popleft()
        count = visited[x]

        if x == K:
            result = count
            result_count += 1
            continue

        for nx in [x-1, x+1, x*2]:
            if 0 <= nx < 100001:
                if visited[nx] == 0 or visited[nx] == visited[x] + 1:
                    visited[nx] = count + 1
                    q.append(nx)

    print(result, result_count, sep='\n')

visited[N] = 0
bfs()

