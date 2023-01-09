T = int(input())

def solve():
    global N
    N = int(input())
    dfs(2, "1")
    print()

def dfs(depth, result):
    if depth == N + 1:
        cal(result)
        return
    dfs(depth+1, result + " " + str(depth))
    dfs(depth+1, result + "+" + str(depth))
    dfs(depth+1, result + "-" + str(depth))

def cal(result):
    temp = result.replace(" ", "")

    if eval(temp) == 0:
        print(result)
    
for _ in range(T):
    solve()