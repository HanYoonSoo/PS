import sys
input = sys.stdin.readline
from collections import deque
N, L = map(int, input().split())
station = [list() for _ in range(N+1)]
line = [list() for _ in range(L)]
for i in range(L):
    tmp = list(map(int, input().split()))
    for j in range(len(tmp)):
        if tmp[j] == -1: break
        station[tmp[j]].append(i)    # 역에 연결되어있는 라인
        line[i].append(tmp[j])  # 라인에 연결되어있는 역

START, END = map(int, input().split())
def bfs(START, END):
    if START == END: return 0
    visit = [-1 for _ in range(N + 1)]
    visit_line = [False for _ in range(L)]
    q = deque()
    visit[START] = 0
    for tmp_line in station[START]:
        q.append((START, tmp_line))
        visit_line[tmp_line] = True
    while q:
        cur_node, cur_line = q.popleft()
        # print(cur_node, cur_line)
        for adj_node in line[cur_line]:
            if visit[adj_node] != -1: continue
            if adj_node == END:
                return visit[cur_node]
            visit[adj_node] = visit[cur_node] + 1
            for connected_line in station[adj_node]:
                if visit_line[connected_line]: continue
                q.append((adj_node, connected_line))
    return -1

print(bfs(START,END))