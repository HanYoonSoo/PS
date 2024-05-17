N = int(input().rstrip())

jjak = ['3', '6', '9']

for i in range(1, N + 1):
    result = ''
    for j in str(i):
        if j in jjak:
            result += '-'

    if '-' not in result:
        result += str(i)

    print(result, end = ' ')


