T = int(input().rstrip())

for test_case in range(1, T + 1):
    N = int(input().rstrip())

    print(f'#{test_case}')
    pascal = []

    for i in range(1, N + 1):
        pascal.append([0] * i)

    pascal[0][0] = 1

    for i in range(N):
        for j in range(i + 1):
            if j == 0:
                pascal[i][j] = 1
            elif i == j:
                pascal[i][j] = 1
            else:
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j]

        for num in pascal[i]:
            print(num, end = ' ')

        print()
