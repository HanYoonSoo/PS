import sys

def sudoku(depth):
    if len(zeros) == depth:
        for i in graph:
            print(*i, sep='')
        exit(0)

    x, y = zeros[depth]
    nx, ny = x // 3, y // 3

    temp = number[:]

    # 가로, 세로
    for i in range(9):
        if graph[x][i] in temp:
            temp.remove(graph[x][i])
        if graph[i][y] in temp:
            temp.remove(graph[i][y])

    for i in range(nx * 3, (nx+1) * 3):
        for j in range(ny * 3, (ny + 1) * 3):
            if graph[i][j] in temp:
                temp.remove(graph[i][j])

    for i in temp:
        graph[x][y] = i
        sudoku(depth+1)
    graph[x][y] = 0



graph = []
for _ in range(9):
    graph.append(list(map(int, sys.stdin.readline().rstrip())))

zeros = []
for i in range(9):
    for j in range(9):
        if not graph[i][j]:
            zeros.append((i, j))

number = [i for i in range(1, 10)]

sudoku(0)