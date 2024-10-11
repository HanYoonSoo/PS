import sys
sys.setrecursionlimit(10 ** 6)

def solution(a, edges):
    N = len(a)
    tree = [[] for _ in range(N)]
    compute = [0] * N
    result = 0

    check = any(a[i] != 0 for i in range(N))
    if not check:
        return 0

    arr = [0] * N
    for i in range(N):
        arr[i] = a[i]
        compute[i] = arr[i]

    for edge in edges:
        parent, child = edge
        tree[parent].append(child)
        tree[child].append(parent)

    def dfs(parent, before):
        nonlocal result
        if len(tree[parent]) == 1 and tree[parent][0] == before:
            return arr[parent]

        for node in tree[parent]:
            if node != before:
                num = dfs(node, parent)
                result += abs(num)

                if num < 0:
                    compute[parent] -= abs(num)
                else:
                    compute[parent] += num

        return compute[parent]

    compare = dfs(0, -1)
    return result if compare == 0 else -1
