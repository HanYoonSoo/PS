import math

N = int(input())

temp = list(map(int, input().split()))

def find_one(n, k):
    if len(result) == N-1:
        result.append(number[-1])
        return

    divide = math.factorial(n) // n
    index = math.ceil(k / divide)
    result.append(number.pop(index))
    find_one(n-1, k - (divide * (index-1)))

def find_two():
    n = N

    for num in K:
        divide = math.factorial(n) // n
        index = number.index(num)
        if len(number) == 2:
            index += 1
            result.append(divide * index)
            return

        number.pop(index)
        result.append(divide * index)
        n -= 1



if temp[0] == 1:
    K = temp[1]

    number = list(range(0, N+1))
    result = []
    find_one(N,K)
    print(' '.join(map(str, result)))
elif temp[0] == 2:
    K = temp[1:]

    number = list(range(1, N+1))
    result = []
    find_two()
    print(sum(result))
