from collections import deque

def bfs():
    q = deque()

    q.append((su, 0))
    visited[su] = True

    while q:
        x, time = q.popleft()

        if x == si:
            print(time)
            return

        if x * 2 <= 100000 and not visited[x * 2]:
            q.appendleft((x * 2, time))
            visited[x * 2] = True

        if x + 1 <= 100000 and not visited[x + 1]:
            q.append((x + 1, time + 1))
            visited[x + 1] = True

        if 0 <= x - 1 <= 100000 and not visited[x - 1]:
            q.append((x - 1, time + 1))
            visited[x - 1] = True


su, si = map(int, input().split())
visited = [False] * 100001
bfs()