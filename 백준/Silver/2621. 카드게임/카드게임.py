import sys

input = sys.stdin.readline

color = []
number = []

for _ in range(5):
    a, b = input().split()

    color.append(a)
    number.append(int(b))

number.sort()
isSorted = True
colorCount = [0] * 5
numberCount = [0] * 10

color_dict = {}

color_dict['R'] = 1
color_dict['B'] = 2
color_dict['Y'] = 3
color_dict['G'] = 4

compare = number[0]

for i in range(5):
    colorCount[color_dict[color[i]]] += 1
    numberCount[number[i]] += 1

    if compare != number[i]:
        isSorted = False
    else:
        compare += 1

if max(colorCount) == 5 and isSorted:
    print(number[i] + 900)
elif max(numberCount) == 4:
    print(numberCount.index(max(numberCount)) + 800)
elif max(numberCount) == 3 and 2 in numberCount:
    print(numberCount.index(max(numberCount)) * 10 + numberCount.index(2) + 700)
elif max(colorCount) == 5:
    print(number[4] + 600)
elif isSorted:
    print(number[4] + 500)
elif max(numberCount) == 3:
    print(numberCount.index(3) + 400)
elif numberCount.count(2) == 2:
    index = 0
    for i in range(1, 10):
        if numberCount[i] == 2:
            index = max(index, i)
    print(index * 10 + numberCount.index(2) + 300)
elif max(numberCount) == 2:
    print(numberCount.index(2) + 200)
else:
    print(number[4] + 100)



# R7, R8, G9, Y6, B5


# R7, Y7, R2, G7, R5

# R5, Y5, Y4, G9, B4