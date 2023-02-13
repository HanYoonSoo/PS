import sys
from collections import deque

input = sys.stdin.readline

T = int(input())

def new_map(graph):
    for i in graph:
        i.insert(0, '.')
        i.append('.')
    graph.insert(0, ['.'] * (M+2))
    graph.append(['.'] * (M+2))

def bfs():
    q = deque()
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    q.append((0, 0))
    visited = [[False] * (M+2) for _ in range(N+2)]

    visited[0][0] = True

    count = 0
    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N + 2 and 0 <= ny < M+2 and not visited[nx][ny] and graph[nx][ny] != '*':
                if graph[nx][ny] == '.':
                    visited[nx][ny] = True
                    q.append((nx, ny))
                elif graph[nx][ny].islower():
                    keys[ord(graph[nx][ny]) - ord('a')] += 1
                    graph[nx][ny] = '.'

                    q = deque()
                    visited = [[False] * (M+2) for _ in range(N+2)]
                    visited[nx][ny] = True
                    q.append((nx, ny))

                elif graph[nx][ny].isupper():
                    if keys[ord(graph[nx][ny]) - ord('A')] >= 1:
                        visited[nx][ny] = True
                        q.append((nx, ny))
                        graph[nx][ny] = '.'


                elif graph[nx][ny] == '$':
                    count += 1
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    graph[nx][ny] = '.'

    return count

for _ in range(T):
    N, M = map(int, input().split())

    graph = []
    for _ in range(N):
        graph.append(list(input().rstrip()))

    new_map(graph)

    keys = [0] * 26
    key = list(input().rstrip())

    for k in key:
        if k != '0':
            keys[ord(k) - ord('a')] = 1

    print(bfs())


