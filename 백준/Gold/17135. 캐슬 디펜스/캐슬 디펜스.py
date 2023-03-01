import sys
from itertools import combinations
import copy

input = sys.stdin.readline

N, M, D = map(int, input().split())

graph = []
number = list(range(0, M))

for _ in range(N):
    graph.append(list(map(int, input().split())))

def isEmpty(temp_graph):
    for i in range(N):
        if 1 in temp_graph[i]:
            return False

    return True

def attack(archer, temp_graph):
    attack_enemy = []
    count = 0

    for a in archer:
        possible = []

        for i in range(N):
            for j in range(M):
                if temp_graph[i][j] == 1:
                    distance = abs(N-i) + abs(a - j)
                    if distance <= D:
                        possible.append((i, j, distance))

        possible.sort(key=lambda x: (x[2], x[1]))
        if possible:
            attack_enemy.append(possible[0])

    for x, y, distance in attack_enemy:
        if temp_graph[x][y] == 1:
            temp_graph[x][y] = 0
            count += 1

    return count

def move(temp_graph):
    for i in range(N-1, 0, -1):
        temp_graph[i] = temp_graph[i-1]
    temp_graph[0] = [0] * M

result = 0

for archer in combinations(number, 3):
    temp_graph = copy.deepcopy(graph)

    count = 0

    while not isEmpty(temp_graph):
        count += attack(archer, temp_graph)

        move(temp_graph)

    result = max(result, count)

print(result)

