import sys

input = sys.stdin.readline

N = int(input().rstrip())

arr = list(input().rstrip())

result = -1 * sys.maxsize

def compute(num1, operate, num2):
    if operate == '+':
        return num1 + num2
    elif operate == '-':
        return num1 - num2
    elif operate == '*':
        return num1 * num2

def dfs(depth, number):
    global result
    if depth == N-1:
        result = max(result, number)
        return
    if depth + 2 < N:
        dfs(depth + 2, compute(number, arr[depth + 1], int(arr[depth + 2])))

    if depth + 4 < N:
        dfs(depth + 4, compute(number, arr[depth + 1], compute(int(arr[depth + 2]), arr[depth + 3], int(arr[depth + 4]))))

dfs(0, int(arr[0]))

print(result)
