N = int(input())

arr = list(map(int, input().split()))

tree = [[] for _ in range(N)]

temp = int(input())
parent = -2
for i in range(len(arr)):
    if arr[i] != -1 and i != temp:
        tree[arr[i]].append(i)

    if arr[i] == -1 and i != temp:
        parent = i
tree[temp] = []
count = 0
def dfs(node):
    global count
    if len(tree[node]) == 0:
        count += 1
        return

    for v in tree[node]:
        dfs(v)

if parent != -2:
    dfs(parent)

print(count)
