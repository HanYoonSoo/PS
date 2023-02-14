N = list(map(int, input()))

N.sort(reverse=True)

if sum(N) % 3 != 0 or '0' not in map(str, N):
    print(-1)
else:
    print(''.join(map(str, N)))