N = int(input())

nominate = []

for _ in range(N):
    nominate.append(int(input()))

count = 0
while nominate.index(max(nominate)) != 0:
    nominate[nominate.index(max(nominate))] -= 1
    nominate[0] += 1
    count += 1

if nominate.count(max(nominate)) >= 2:
    print(count + 1)
else:
    print(count)