import sys

N, S = map(int,sys.stdin.readline().split())

number = list(map(int, sys.stdin.readline().split()))

distance = 100000000

end = 0
start = 0
total = 0

number.append(0)

while end <= N and start <= N:
    if total >= S and distance > end - start:
        distance = end - start
        total -= number[start]
        start += 1
    elif total < S:
        total += number[end]
        end += 1
    else:
        total -= number[start]
        start += 1

if distance == 100000000:
    print(0)
else:
    print(distance)