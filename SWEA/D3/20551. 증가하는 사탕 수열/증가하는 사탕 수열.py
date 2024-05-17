T = int(input().rstrip())

for test_case in range(1, T + 1):
    box1, box2, box3 = map(int, input().split())

    result = 0
    if box3 == 1:
        print(f'#{test_case} -1')
    else:
        if (box3 - 1) <= box2:
            result += abs((box3-1) - box2)
            box2 -= result
        else:
            if box2 < 2:
                print(f'#{test_case} -1')
                continue

        if (box2 - 1) <= box1:
            result += abs((box2-1) - box1)

        print(f'#{test_case}', result)