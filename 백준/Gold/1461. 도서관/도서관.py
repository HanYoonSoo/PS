import sys

N, M = map(int, sys.stdin.readline().split())

arr = list(map(int, sys.stdin.readline().split()))

plus = []
minus = []

for i in range(N):
    if arr[i] > 0:
        plus.append(arr[i])
    else:
        minus.append(arr[i])

plus.sort(reverse=True)
minus.sort()

distance = []

for i in range(len(plus) // M):
    distance.append(plus[i * M])
if len(plus) % M > 0:
    distance.append(plus[len(plus) // M * M])

for i in range(len(minus) // M):
    distance.append(abs(minus[M * i]))
if len(minus) % M > 0:
    distance.append(abs(minus[len(minus) // M * M]))

distance.sort()

result = distance.pop()

result += 2 * sum(distance)

print(result)
