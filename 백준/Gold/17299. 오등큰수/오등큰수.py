import sys

input = sys.stdin.readline

N = int(input().rstrip())

list = list(map(int, input().split()))

stack = []

count = [0] * 1000001
index = [0] * 1000001
result = [0] * (N + 1)

for i in range(1, N + 1):
    index[i] = list[i - 1]
    count[index[i]] += 1

for i in range(1, N + 1):
    while stack and count[index[stack[-1]]] < count[index[i]]:
        result[stack.pop()] = index[i]
    stack.append(i)

while stack:
    result[stack.pop()] = -1

for i in range(1, N + 1):
    print(result[i], end = ' ')
