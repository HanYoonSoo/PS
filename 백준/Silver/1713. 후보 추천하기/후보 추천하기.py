N = int(input())

recommend = int(input())

arr = list(map(int, input().split()))

nomination = {}

for i in range(len(arr)):
    if arr[i] in nomination:
        nomination[arr[i]][0] += 1
    else:
        if len(nomination) < N:
            nomination[arr[i]] = [1, i]
        else:
            delete = sorted(nomination.items(), key = lambda x : (x[1][0], x[1][1]))
            del_key = delete[0][0]
            del(nomination[del_key])
            nomination[arr[i]] = [1, i]

print(' '.join(map(str, sorted(nomination.keys()))))