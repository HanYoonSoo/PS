import sys

input = sys.stdin.readline

T = int(input().rstrip())

for _ in range(T):
    N, M = map(int, input().split())

    request = []
    for _ in range(M):
        a, b = map(int, input().split())
        request.append((a, b))

    request.sort(key=lambda x : x[1])

    book = [False] * (N+1)

    count = 0

    while request:
        a, b = request.pop(0)

        for i in range(a, b + 1):
            if not book[i]:
                book[i] = True
                count += 1
                break

    print(count)




