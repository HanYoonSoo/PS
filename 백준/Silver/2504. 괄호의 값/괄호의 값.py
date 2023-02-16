arr = list(input())

stack = []

temp = 1
result = 0
for i in range(len(arr)):
    if arr[i] == '(':
        temp *= 2
        stack.append(arr[i])
    elif arr[i] == '[':
        temp *= 3
        stack.append(arr[i])
    elif arr[i] == ')':
        if not stack or stack[-1] == '[':
            result = 0
            break

        if arr[i-1] == '(':
            result += temp
        stack.pop()
        temp //= 2
    else:
        if not stack or stack[-1] == '(':
            result = 0
            break

        if arr[i-1] == '[':
            result += temp
        stack.pop()
        temp //= 3

if stack:
    print(0)
else:
    print(result)


