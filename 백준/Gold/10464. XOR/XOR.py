def f(a):
    b = a % 4
    if b == 0:
        b = a
    elif b == 1:
        b = 1
    elif b == 2:
        b = a + 1
    elif b == 3:
        b = 0
    return b

def main():
    n = int(input())
    while n > 0:
        a, b = map(int, input().split())
        a -= 1
        print(f(b) ^ f(a))
        n -= 1

if __name__ == "__main__":
    main()
