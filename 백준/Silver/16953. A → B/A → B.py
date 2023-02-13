import sys

A, B = map(int, input().split())

result = sys.maxsize
def dfs(num, depth):
    global result

    if num == B:
        result = min(result, depth)
        return

    if num > B:
        return

    dfs(num * 2, depth + 1)
    dfs(num * 10 + 1, depth + 1)

dfs(A, 1)

if result == sys.maxsize:
    print(-1)
else:
    print(result)
