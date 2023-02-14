from collections import deque

N, K = map(int, input().split())

visited = [-1] * 100001
path = []
def bfs():
    q = deque()
    q.append((N, 0))

    result = 0

    while q:
        x, count = q.popleft()
        
        if x == K:
            result = count

            while x != N:
                path.append(x)
                x = visited[x]
            path.append(N)
            break

        for nx in [x-1, x+1, x*2]:
            if 0 <= nx < 100001:
                if visited[nx] == -1:
                    visited[nx] = x
                    q.append((nx, count + 1))

    print(result)
    print(' '.join(map(str,path[::-1])))

visited[N] = 0
bfs()


