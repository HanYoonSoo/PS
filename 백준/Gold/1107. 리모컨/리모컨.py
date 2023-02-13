import sys

input = sys.stdin.readline

target = int(input())

N = int(input())
if N == 0:
    print(min(abs(100 - target), len(str(target))))
    exit(0)
broken = list(map(int, input().split()))

min_count = abs(100 - target)

for i in range(1000000):
    nums = str(i)

    for j in range(len(nums)):
        if int(nums[j]) in broken:
            break

        if j == len(nums) - 1:
            min_count = min(min_count, len(nums) + abs(int(nums) - target))

print(min_count)

