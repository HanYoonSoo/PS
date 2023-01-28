N = int(input())

str = []

for _ in range(N):
    str.append(input())

alpha = [0] * 26

for i in range(len(str)):
    temp = len(str[i])-1
    for j in str[i]:
        alpha[ord(j) - ord('A')] += 10 ** temp
        temp -= 1

alpha.sort(reverse=True)

index = 9

result = 0

for i in range(len(alpha)):
    if not alpha[i]:
        break

    result += alpha[i] * index
    index -= 1

print(result)