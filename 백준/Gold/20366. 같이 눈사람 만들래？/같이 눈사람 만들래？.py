# 5
# 3 5 2 5 9
#
# 2 3 5 5 9
#

import sys

input = sys.stdin.readline

T = int(input().rstrip())
nums = list(map(int, input().split()))

nums.sort()

result = sys.maxsize

for i in range(len(nums)):
    for j in range(i + 3, len(nums)):
        l = i + 1
        r = j - 1

        while l < r:
            temp = nums[i] + nums[j] - (nums[l] + nums[r])

            if result > abs(temp):
                result = abs(temp)

            if temp < 0:
                r -= 1
            else:
                l += 1

print(result)


