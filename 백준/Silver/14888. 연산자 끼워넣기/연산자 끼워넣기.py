import sys

N = int(input())

number = list(map(int, input().split()))

cal = list(map(int, input().split()))

minValue = sys.maxsize
maxValue = -sys.maxsize
def calculate(idx, total, plus, minus, mul, divide):
    global minValue
    global maxValue

    if idx == N:
        maxValue = max(total, maxValue)
        minValue = min(total, minValue)
        return


    if plus:
        calculate(idx + 1, total + number[idx], plus - 1, minus, mul, divide)
    if minus:
        calculate(idx + 1, total - number[idx], plus, minus - 1, mul, divide)
    if mul:
        calculate(idx + 1, total * number[idx], plus , minus, mul - 1, divide)
    if divide:
        calculate(idx + 1, int(total / number[idx]), plus, minus, mul, divide - 1)

calculate(1, number[0], cal[0], cal[1], cal[2], cal[3])
print(maxValue)
print(minValue)



