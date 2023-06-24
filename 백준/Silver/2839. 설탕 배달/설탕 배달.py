import sys

input = sys.stdin.readline

N = int(input().rstrip())

minNum = 5000

for i in range(N//5 + 1):
    count = 5000
    if (N - 5 * i) % 3 == 0:
        count = i + (N - 5 * i) // 3

    minNum = min(count, minNum)

if minNum == 5000:
    print(-1)
else:
    print(minNum)