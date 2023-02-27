import sys

input = sys.stdin.readline

N = int(input().rstrip())
K = int(input().rstrip())

number = list(map(int, input().split()))

number.sort()

distance = []

for i in range(N-1):
    distance.append(number[i+1] - number[i])

distance.sort()

print(sum(distance[:N-K]))
