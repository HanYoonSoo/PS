import sys
from collections import Counter

input = sys.stdin.readline

str = list(input().rstrip())

str.sort()

check = Counter(str)

count = 0

mid = ''
for s, c in check.items():
    if c % 2 == 1:
        count += 1
        mid = s
        str.remove(s)
        if count == 2:
            print("I'm Sorry Hansoo")
            exit(0)

result = ''
for i in range(0, len(str), 2):
    result += str[i]

print(result + mid + result[::-1])