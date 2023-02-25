def solution(s, skip, index):
    result = ''
    
    for i in range(len(s)):
        compare = ord(s[i])
        for j in range(1, index + 1):
            compare = compare + 1

            if compare > ord('z'):
                compare = ord('a') + compare - ord('z') - 1

            while chr(compare) in list(skip):
                compare = compare + 1

                if compare > ord('z'):
                    compare = ord('a') + compare - ord('z') - 1

        result += chr(compare)

    return result