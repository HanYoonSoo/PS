import sys

input = sys.stdin.readline

S = list(input().strip())
T = list(input().strip())

while len(T) >0:
  if S == T:
    print(1)
    exit()
  if T.pop() == 'A':
    continue
  else:
    T.reverse()

print(0)