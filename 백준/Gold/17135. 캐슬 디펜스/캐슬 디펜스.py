import sys
import copy
from itertools import combinations

input = sys.stdin.readline

n,m,d = map(int, input().split())

graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))

number = list(range(0, m))

def isEmpty(temp):
    for i in range(n):
        if 1 in temp[i]:
            return False
    return True

def attack(arrow, temp):

    attack_enemy = []
    count = 0
    for l in arrow:
        possible = []
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 1:
                    distance = abs(i-n) + abs(j-l)

                    if d >= distance:
                        possible.append((distance, i, j))

        possible.sort(key = lambda x: (x[0], x[2]))

        if possible:
            attack_enemy.append(possible[0])

    for _, i, j in attack_enemy:
        if temp[i][j] == 1:
            temp[i][j] = 0
            count += 1

    return count

def move(temp):
    for i in range(n-1, 0, -1):
        temp[i] = temp[i-1]

    temp[0] = [0] * m

result = 0
for arrow in combinations(number, 3):
    temp = copy.deepcopy(graph)

    count = 0

    while not isEmpty(temp):
        count += attack(arrow, temp)

        move(temp)

    result = max(result, count)

print(result)

