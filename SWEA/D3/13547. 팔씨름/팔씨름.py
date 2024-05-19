T = int(input().rstrip())

for test_case in range(1, T + 1):
    str = input()

    lose = 0
    for s in str:
        if s == 'x':
            lose += 1

    if lose > 7:
        print(f'#{test_case} NO')
    else:
        print(f'#{test_case} YES')

