num_gate = int(input())
num_airplane = int(input())
docking = list(range(num_gate+1))

airplanes = []
for _ in range(num_airplane):
    airplanes.append(int(input()))

def find_root(airplane):
    stack = [airplane]
    while True:
        parking = docking[airplane]
        if parking == airplane:
            break
        else:
            stack.append(parking)
            airplane = docking[parking]

    while stack:
        temp = stack.pop()
        docking[temp] = parking

    return parking

def union(a, b):
    a = find_root(a)
    b = find_root(b)

    docking[a] = b

count = 0

for i in range(num_airplane):
    airplane = airplanes[i]
    root = find_root(airplane)

    if root == 0:
        break

    union(root, root - 1)
    count += 1

print(count)
