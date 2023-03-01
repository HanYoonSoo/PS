import sys
from collections import deque
import copy

input = sys.stdin.readline

graph = ''

for i in range(3):
    temp = input().rstrip()
    temp = temp.replace(' ', '')
    graph += temp

graph = graph.replace('0', '9')

graph_dict = {}

graph_dict[graph] = 0

q = deque()

q.append(graph)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

while q:
    temp_graph = q.popleft()
    count = graph_dict[temp_graph]

    if temp_graph == '123456789':
        print(count)
        exit(0)

    point = temp_graph.find('9')
    x = point // 3
    y = point % 3

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < 3 and 0 <= ny < 3:
            npoint = nx * 3 + ny
            change_num = list(temp_graph)
            change_num[npoint], change_num[point] = change_num[point], change_num[npoint]

            change_num = ''.join(change_num)

            if change_num not in graph_dict:
                q.append(change_num)
                graph_dict[change_num] = count + 1

print(-1)
