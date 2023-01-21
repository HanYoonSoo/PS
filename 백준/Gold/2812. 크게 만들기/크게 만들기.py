import copy

N, K = map(int, input().split())

arr = list(input())

stack = []

k = K
for i in range(N):
    while k > 0 and stack and stack[-1] < arr[i]:
        stack.pop()
        k -= 1
    stack.append(arr[i])

print(''.join(stack[:N-K]))


