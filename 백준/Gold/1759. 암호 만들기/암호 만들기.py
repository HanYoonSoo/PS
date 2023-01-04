import sys

def backtracking(count, idx):
    if count == L:
        mo, ja = 0, 0

        for i in range(L):
            if answer[i] in moArr:
                mo += 1
            else:
                ja += 1

        if mo >= 1 and ja >= 2:
            print("".join(answer))
        return

    for i in range(idx, C):
        answer.append(words[i])
        backtracking(count + 1, i + 1)
        answer.pop()


L, C = map(int, sys.stdin.readline().split())
words = sorted(list(map(str, sys.stdin.readline().split())))
moArr = ['a', 'e', 'i', 'o', 'u']
answer = []
backtracking(0, 0)