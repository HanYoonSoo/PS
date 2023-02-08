import sys

N = int(sys.stdin.readline())

subject = []

maxDay = 0
for _ in range(N):
    d, v = map(int, sys.stdin.readline().split())

    if maxDay < d:
        maxDay = d

    subject.append([d, v])

subject.sort(reverse = True)

result = 0
for i in range(maxDay, 0, -1):
    temp = 0
    tempIdx = -1
    for j in range(len(subject)):
        if i <= subject[j][0]:
            if temp < subject[j][1]:
                temp = subject[j][1]
                tempIdx = j
    result += temp
    if tempIdx != -1:
        subject.pop(tempIdx)

print(result)