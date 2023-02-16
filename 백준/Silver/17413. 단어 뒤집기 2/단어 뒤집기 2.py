word = list(input())

idx = 0

while idx < len(word):
    if word[idx] == '<':
        while idx < len(word) and word[idx] != '>':
            idx += 1
    elif word[idx].isalnum():
        start = idx

        while idx < len(word) and word[idx].isalnum():
            idx += 1

        temp_word = word[start:idx]
        temp_word.reverse()
        word[start:idx] = temp_word

    else:
        idx += 1

print(''.join(word))