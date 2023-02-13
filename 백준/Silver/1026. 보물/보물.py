import sys

input = sys.stdin.readline

N = int(input())

min_arr = list(map(int, input().split()))
max_arr = list(map(int, input().split()))

result = 0

for i in range(N):
    minValue = min_arr.pop(min_arr.index(min(min_arr)))
    maxValue = max_arr.pop(max_arr.index(max(max_arr)))
    result += minValue * maxValue

print(result)