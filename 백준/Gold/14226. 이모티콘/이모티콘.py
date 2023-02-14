from collections import deque

N = int(input())

visited = [[-1] * (N+1) for _ in range(N+1)]

def bfs():
    q = deque()
    q.append((1, 0))
    visited[1][0] = 0

    while q:
        s, c = q.popleft()

        if s + c <= N and visited[s+c][c] == -1 and c != 0:
            q.append((s+c, c))
            visited[s+c][c] = visited[s][c] + 1

        if visited[s][s] == -1:
            q.append((s, s))
            visited[s][s] = visited[s][c] + 1

        if s - 1 >= 0 and visited[s-1][c] == -1:
            q.append((s-1, c))
            visited[s-1][c] = visited[s][c] + 1

bfs()

result = -1
for i in range(1, N + 1):
    if visited[N][i] != -1:
        if result == -1 or result > visited[N][i]:
            result = visited[N][i]

print(result)
