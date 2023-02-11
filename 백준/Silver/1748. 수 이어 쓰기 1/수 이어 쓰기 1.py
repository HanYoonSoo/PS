n = input()

length = len(n) - 1

count = 0
i = 0

while i < length:
    count += 9 * (10 ** i) * (i + 1)
    i += 1

count += (int(n) - (10 ** length) + 1) * (length + 1)

print(count)
# 253 = 63 + 9 + 180
