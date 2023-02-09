arr = list(map(int, input()))

number = [0] * (10)

count = 1

for i in arr:
    if i == 6 or i == 9:
        if number[6] <= number[9]:
            number[6] += 1
        else:
            number[9] += 1
    else:
        number[i] += 1

print(max(number))
