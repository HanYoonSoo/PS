number = list(map(int, input()))

left = 0
right = 0

for i in range(len(number)):
    if i < len(number) // 2:
        left += number[i]
    else:
        right += number[i]

if left == right:
    print("LUCKY")
else:
    print("READY")