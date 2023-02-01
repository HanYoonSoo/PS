str = input()
boom = input()

stack = []
last = boom[-1]

for i in str:
    stack.append(i)

    if len(stack) >= len(boom):
        if stack[-1] == last and ''.join(stack[-1*len(boom):]) == boom:
            del stack[-1*len(boom):]

if len(stack) == 0:
    print("FRULA")
else:
    print(''.join(stack))

