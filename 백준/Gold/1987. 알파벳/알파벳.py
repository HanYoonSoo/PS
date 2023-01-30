R, C = map(int, input().split())

graph = []
for _ in range(R):
    graph.append(list(input()))

visited = [False] * 26

result = 0
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def dfs(x, y, count):
    if visited[ord(graph[x][y]) - ord('A')]:
        global result
        result = max(result, count)
    else:
        visited[ord(graph[x][y]) - ord('A')] = True
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < R and 0 <= ny < C:
                dfs(nx, ny, count + 1)

        visited[ord(graph[x][y]) - ord('A')] = False

dfs(0, 0, 0)

print(result)