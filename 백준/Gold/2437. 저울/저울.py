import sys

input = sys.stdin.readline

N = int(input().rstrip())
coin = list(map(int, input().split()))

coin.sort()

total = 1

for i in range(len(coin)):
    if total < coin[i]:
        break
    else:
        total += coin[i]
        
print(total)

