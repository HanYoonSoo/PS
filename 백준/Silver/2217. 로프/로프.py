N = int(input())

weight = []

for _ in range(N):
    weight.append(int(input()))

weight.sort(reverse=True)

result = 0
for i in range(len(weight)):
    result = max(result, weight[i] * (i+1))

print(result)