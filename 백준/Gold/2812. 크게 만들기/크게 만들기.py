N, K = map(int, input().split())

number = list(input())

stack = []

count = K

for i in range(N):
    while count > 0 and stack and stack[-1] < number[i]:
        stack.pop()
        count -= 1
    stack.append(number[i])

print(''.join(stack[:N-K]))

