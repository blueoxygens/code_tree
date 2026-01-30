import math
n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
def dist (x,y,u,v):
    return abs(x-u) + abs(y-v)

memo = [[-1]*n for _ in range(n)]

m = math.inf
for k in range(1,n-1):
    ans = 0
    for i in range(n-1):
        if i == k:
            continue
        if i + 1 == k:
            if memo[i][i+2] == -1:
                memo[i][i+2] = dist(x[i],y[i],x[i+2],y[i+2])
            ans +=  memo[i][i+2]
        else:
            if memo[i][i+1] == -1:
                memo[i][i+1] = dist(x[i],y[i],x[i+1],y[i+1])
            ans +=  memo[i][i+1]
    m = min(m,ans)

print(m)
