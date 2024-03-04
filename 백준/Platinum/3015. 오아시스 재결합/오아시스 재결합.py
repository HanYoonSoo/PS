import sys

input = sys.stdin.readline

N = int(input().rstrip())

stack = []

result = 0

for i in range(N):
    num = int(input().rstrip())
    pair = [num, 1]
    while stack and stack[-1][0] <= num:
        pop = stack.pop()
        result += pop[1]
        if num == pop[0]:
            pair[1] += pop[1]

    if stack:
        result += 1

    stack.append(pair)

print(result)