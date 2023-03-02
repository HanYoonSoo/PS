from itertools import permutations

def isPrime(new_nums, result):
    for nums in new_nums:
        if nums < 2:
            continue
        compare = True
        for i in range(2, int(nums ** 0.5) + 1):
            if nums % i == 0:
                compare = False
                break
        if compare:
            result.append(nums)
        
def solution(numbers):
    nums = []
    
    for n in numbers:
        nums.append(n)
    
    arr = []
    for i in range(1, len(nums) + 1):
        arr += list(permutations(nums, i))
    
    new_nums = []
    
    for i in range(len(arr)):
        new_nums.append(int(''.join(arr[i])))
    
    result = []
    isPrime(new_nums, result)
    
    return len(set(result))