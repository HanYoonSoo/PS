N = int(input())
arr = list(map(int, input().split()))
arr.sort()

result = 1
for i in arr:
    if result < i:
        break
    result += i
print(result)