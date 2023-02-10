import sys

input = sys.stdin.readline

graph = []

R, C = map(int, input().split())

for _ in range(R):
    graph.append(list(input().rstrip()))

def dfs(x, y):
    if y == C - 1:
        return True

    for dx in [-1, 0, 1]:
        nx = x + dx
        ny = y + 1

        if 0 <= nx < R and 0 <= ny < C:
            if graph[nx][ny] != 'x' and not visited[nx][ny]:
                visited[nx][ny] = True
                if dfs(nx, ny):
                    return True
    return False

result = 0
visited = [[False] * C for _ in range(R)]
for i in range(R):
    if dfs(i, 0):
        result += 1
print(result)

