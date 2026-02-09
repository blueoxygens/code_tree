import math
n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
def dist (x,y,u,v):
    return (x-u)**2+(y-v)**2

ans = math.inf
for i in range(n-1):
    for j in range(i+1,n):
        ans = min(ans, dist(x[i],y[i],x[j],y[j]))

print(ans)