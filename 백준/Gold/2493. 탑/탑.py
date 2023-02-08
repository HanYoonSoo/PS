import sys

N = int(sys.stdin.readline())

top = list(map(int, sys.stdin.readline().split()))

stack = []
result = []

for i in range(N):
    while stack:
        if stack[-1][1] < top[i]:
            stack.pop()
        else:
            result.append(stack[-1][0])
            break

    if not stack:
        result.append(0)
    stack.append(((i+1),top[i]))

print(' '.join(map(str,result)))

