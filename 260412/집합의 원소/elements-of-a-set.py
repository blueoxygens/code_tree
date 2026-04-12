n, m = map(int, input().split())

# Please write your code here.
commands = [tuple(map(int,input().split(" "))) for _ in range(m)]
parents = [i for i in range(n+1)]

def find(x):
    if parents[x] != x:
        parents[x] = find(parents[x])  # 경로 압축
    return parents[x]

def union(x,y):

    x = find(x)
    y = find(y)

    if x < y:
        parents[y] = x
    else:
        parents[x] = y


for c, x, y in commands:
    if c == 0:
        union(x,y)
    else:
        if find(x) == find(y):
            print(1)
        else:
            print(0)