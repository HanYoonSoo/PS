T = int(input().rstrip())

for test_case in range(1, T + 1):
    N = int(input().rstrip())
    arr = list(map(int, input().split()))

    result = 0

    maxIdx = arr.index(max(arr))
    pay = 0
    day = 0

    for i in range(len(arr)):
        if i < maxIdx:
            pay += arr[i]
            day += 1
        elif i == maxIdx:
            result += (day * arr[i] - pay)
            if i + 1 < len(arr):
                maxIdx = arr[i + 1:].index(max(arr[i+1:]))
                maxIdx += (i + 1)
            day = 0
            pay = 0

    print(f'#{test_case}', result)