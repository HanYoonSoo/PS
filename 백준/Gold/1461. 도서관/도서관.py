import sys

N, M = map(int, sys.stdin.readline().split())

arr = list(map(int, sys.stdin.readline().split()))

plus = []
minus = []

for i in arr:
    if i < 0:
        minus.append(i)
    elif i > 0:
        plus.append(i)

distance = []
minus.sort()

for i in range(len(minus) // M):
    distance.append(abs(minus[M*i]))
if len(minus) % M > 0:
    distance.append(abs(minus[(len(minus)//M) * M]))

plus.sort(reverse=True)

for i in range(len(plus) // M):
    distance.append(abs(plus[M*i]))
if len(plus) % M > 0:
    distance.append(abs(plus[(len(plus)//M) * M]))

distance.sort()

result = distance.pop()

result += 2 * sum(distance)
print(result)

