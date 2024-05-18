T = int(input().rstrip())

for test_case in range(1, T + 1):
    N = int(input().rstrip())

    str = input()

    if N % 2 == 1:
        print(f'#{test_case} No')
    else:
        print(f'#{test_case}', 'Yes' if str[:N//2] == str[N//2:] else "No")