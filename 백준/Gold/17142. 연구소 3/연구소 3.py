import sys
from itertools import combinations
import copy
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

grid = []

virus = []
for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(N):
        # 바이러스 '*'로 변경
        if temp[j] == 2:
            temp[j] = '*'
            virus.append((i, j))
        # 벽 '-'로 변경
        elif temp[j] == 1:
            temp[j] = '-'
    grid.append(temp)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def check(temp_grid):
    count0 = 0  # 0의 갯수 확인
    maxCount = 0 # 최단 거리 계산

    for i in range(N):
        for j in range(N):
            if temp_grid[i][j] == 0:
                count0 += 1

            if temp_grid[i][j] != '*' and temp_grid[i][j] != '-':
                maxCount = max(maxCount, temp_grid[i][j])

    if count0 == M: # 0의 갯수가 M과 같다면 빈칸이 없는 것이므로 최단 거리 반환
        return maxCount
    else:   # 그렇지 않다면 빈칸이므로 -1 반환
        return -1

def bfs(q, visited, temp_grid):
    # for i in range(N):
    #     print(*temp_grid[i])
    # print()

    while q:
        x, y, count = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny] and temp_grid[nx][ny] != '-':
                if temp_grid[nx][ny] != '*': # 바이러스가 아니라면 최단 거리 계산을 위해 카운트 값으로 grid 변경
                    temp_grid[nx][ny] = count + 1
                q.append((nx, ny, count + 1))
                visited[nx][ny] = True

    # for i in range(N):
    #     print(*temp_grid[i])
    #print(active_virus)
    # print()
    return check(temp_grid)


result = sys.maxsize
# print(virus)
for active_virus in combinations(virus, M):
    temp_grid = copy.deepcopy(grid)
    q = deque()
    visited = [[False] * N for _ in range(N)]

    for x, y in active_virus:
        q.append((x, y, 0))
        visited[x][y] = True
        temp_grid[x][y] = 0

    compare = bfs(q, visited, temp_grid)

    # 빈칸이 있지 않은 상태라면 최단 거리 초기화
    if compare != -1:
        result = min(result, compare)
# 바이러스가 전부 다 감염시킬 수 있는 경우가 없을 경우
if result == sys.maxsize:
    print(-1)
else:
    print(result)


