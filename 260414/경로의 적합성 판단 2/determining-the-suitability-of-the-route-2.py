n, m, k = map(int, input().split())

edges = [tuple(map(int, input().split())) for _ in range(m)]
path = list(map(int, input().split()))

# Please write your code here.

parent = [i for i in range(n+1)]

def find (a):
    if parent[a] != a:
        parent[a] = find(parent[a])
    return parent[a]

def union (a,b):
    x = find(a)
    y = find(b)

    if x > y:
        parent[x] = y
    else:
        parent[y] = x

for e1, e2 in edges:
    union(e1,e2)

for i in range(k-1):
    if find(path[i]) != find(path[i+1]):
        print(0)
        break
else:
    print(1)