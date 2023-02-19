from collections import deque

N, K = map(int, input().split())

def bfs():
    visited = [0] * 100001

    q = deque()

    q.append(N)
    visited[N] = 0

    while q:
        x = q.popleft()
        count = visited[x]

        if x == K:
            print(visited[x])
            break

        for location in [x * 2, x - 1, x + 1]:
            if 0 <= location < 100001 and visited[location] == 0:
                visited[location] = count + 1
                q.append(location)

bfs()
