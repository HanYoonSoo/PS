import sys
from collections import deque

input = sys.stdin.readline

wheel = {}

for i in range(1, 5):
    wheel[i] = deque(list(map(int, input().rstrip())))

K = int(input().rstrip())

def check_right(num, dir):
    if num > 4 or wheel[num-1][2] == wheel[num][6]:
        return

    if wheel[num-1][2] != wheel[num][6]:
        check_right(num+1, -dir)
        wheel[num].rotate(dir)

def check_left(num, dir):
    if num < 1 or wheel[num][2] == wheel[num+1][6]:
        return

    if wheel[num][2] != wheel[num+1][6]:
        check_left(num-1, -dir)
        wheel[num].rotate(dir)

for _ in range(K):
    num, dir = map(int, input().split())

    check_right(num+1, -dir)
    check_left(num-1, -dir)
    wheel[num].rotate(dir)

count = 0
temp = 1
for i in range(1, 5):
    count += wheel[i][0] * temp

    temp *= 2

print(count)




