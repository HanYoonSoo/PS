number = input()

count0 = 0
count1 = 0

if number[0] == '0':
    count0 += 1
else:
    count1 += 1

for i in range(len(number) - 1):
    if number[i] == '0' and number[i+1] == '1':
        count1 += 1
    elif number[i] == '1' and number[i+1] == '0':
        count0 += 1

print(min(count0, count1))