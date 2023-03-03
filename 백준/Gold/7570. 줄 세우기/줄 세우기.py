import sys

input = sys.stdin.readline

N = int(input().rstrip())

if N == 1:
    print(0)
    exit(0)
    
arr = list(map(int, input().split()))
arr.insert(0, 0)

location = [0 for _ in range(N+1)]

for i in range(1, N+1):
    location[arr[i]] = i

count = 1

maxNum = -1
for i in range(1, N):
    if location[i] < location[i+1]:
        count += 1

        if count > maxNum:
            maxNum = max(count, maxNum)
    else:
        count = 1

print(N - maxNum)
