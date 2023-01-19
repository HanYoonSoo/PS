import sys

N = int(sys.stdin.readline())
plus = []
minus = []
max_sum = 0

for _ in range(N):
    n = int(sys.stdin.readline())

    if n > 1:
        plus.append(n)
    elif n == 1:
        max_sum += 1
    else:
        minus.append(n)

plus.sort(reverse=True)
minus.sort()


if len(plus) % 2 == 0:
    for i in range(0, len(plus), 2):
        max_sum += plus[i] * plus[i + 1]
else:
    for i in range(0, len(plus) - 1, 2):
        max_sum += plus[i] * plus[i + 1]
    max_sum += plus[len(plus) - 1]




if len(minus) % 2 == 0:
    for i in range(0, len(minus), 2):
        max_sum += minus[i] * minus[i + 1]
else:
    for i in range(0, len(minus) - 1, 2):
        max_sum += minus[i] * minus[i + 1]
    max_sum += minus[len(minus) - 1]

print(max_sum)