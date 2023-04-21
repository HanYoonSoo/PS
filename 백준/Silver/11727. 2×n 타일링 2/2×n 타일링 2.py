tile = [0, 1, 3]
for i in range(3, 1001):
  tile.append((tile[i - 2] * 2) + tile[i - 1])
N = int(input())
print(tile[N] % 10007)