from collections import deque

A, B, C = map(int, input().split())

result = []


def pour(x, y, q):
    if not visited[x][y]:
        visited[x][y] = True
        q.append((x, y))
def bfs():
    q = deque()
    q.append((0, 0))
    visited[0][0] = True

    while q:
        x, y = q.popleft()

        z = C - x - y

        if x == 0:
            result.append(z)

        water = min(z, A - x)
        pour(x + water, y, q)

        water = min(z, B - y)
        pour(x, y + water, q)

        water = min(x, B - y)
        pour(x - water, y + water, q)

        water = min(x, C - z)
        pour(x - water, y, q)

        water = min(y, A - x)
        pour(x + water, y-water, q)

        water = min(y, C - z)
        pour(x, y - water, q)
visited = [[False] * (B + 1) for _ in range(A+1)]
bfs()

result.sort()
print(' '.join(map(str,result)))