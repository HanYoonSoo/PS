T = int(input().rstrip())

for test_case in range(1, T + 1):
    left, right = input().split()
    print(f'#{test_case}', 'yes' if left * len(right) == right * len(left) else 'no')

