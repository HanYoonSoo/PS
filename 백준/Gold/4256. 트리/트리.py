import sys

T = int(sys.stdin.readline())

def postorder(preorder, inorder):
    if len(preorder) == 0:
        return
    elif len(preorder) == 1:
        print(preorder[0], end = ' ')
        return
    elif len(preorder) == 2:
        print(preorder[1], preorder[0], end = ' ')
        return

    root_idx = inorder.index(preorder[0])
    leftIn = inorder[0:root_idx]
    leftPr = preorder[1:1 + len(leftIn)]
    postorder(leftPr, leftIn)

    rightIn = inorder[root_idx+1:]
    rightPr = preorder[len(leftPr)+1:]
    postorder(rightPr, rightIn)

    print(preorder[0], end = ' ')

for _ in range(T):
    node = int(sys.stdin.readline())
    preorder = list(map(int, sys.stdin.readline().split()))
    inorder = list(map(int, sys.stdin.readline().split()))
    postorder(preorder, inorder)
    print()
