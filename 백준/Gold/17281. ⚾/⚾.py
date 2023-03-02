import sys
from itertools import permutations

input = sys.stdin.readline

N = int(input().rstrip())
inning = []

for i in range(N):
    inning.append(list(map(int, input().split())))

def play(playerlist):
    hitting_idx = 0
    score = 0

    for each_inning in inning:
        outCount = 0
        b1, b2, b3 = 0, 0, 0

        while outCount < 3:
            if each_inning[playerlist[hitting_idx]] == 0:
                outCount += 1
            elif each_inning[playerlist[hitting_idx]] == 1:
                score += b3
                b1, b2, b3 = 1, b1, b2
            elif each_inning[playerlist[hitting_idx]] == 2:
                score += (b2 + b3)
                b1, b2, b3 = 0, 1, b1
            elif each_inning[playerlist[hitting_idx]] == 3:
                score += (b1 + b2 + b3)
                b1, b2, b3 = 0, 0, 1
            elif each_inning[playerlist[hitting_idx]] == 4:
                score += (b1 + b2 + b3 + 1)
                b1, b2, b3 = 0, 0, 0
            hitting_idx = (hitting_idx + 1) % 9
    return score

number = list(range(1, 9))
maxScore = 0
for rand_num in permutations(number, 8):
    playerlist = list(rand_num[:3]) + [0] + list(rand_num[3:])
    maxScore = max(maxScore, play(playerlist))

print(maxScore)






