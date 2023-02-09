import sys

str = list(sys.stdin.readline())

i = 0
start = 0

while i < len(str):
    if str[i] == '<':
        while i < len(str) and str[i] != '>':
            i += 1
        i+= 1
    elif str[i].isalnum():
        start = i

        while i < len(str) and str[i].isalnum():
            i += 1
        temp = str[start:i]
        temp.reverse()

        str[start:i] = temp
    else:
        i += 1

print(''.join(str))
