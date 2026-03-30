import math
n, m = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(m)]

# Please write your code here.
distance = [[math.inf]*(n+1) for _ in range(n+1)]
for i in range(1,n+1):
    distance[i][i] = 0
for f, t, v in edges:
    distance[f][t] = min(distance[f][t], v)

for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            distance[i][j] = min(distance[i][j], distance[i][k]+distance[k][j])

for l in distance[1:]:
    for i in l[1:]:
        if i == math.inf:
            print(-1, end = ' ')
        else:
            print(i, end = ' ')
    print()