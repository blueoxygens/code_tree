import math
n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
def distance (x,y,u,v):
    return abs(x-u)+abs(y-v)

r,l = [0]*n,[0]*n

for i in range(1,n):
    l[i] = l[i-1] + distance(x[i],y[i],x[i-1],y[i-1])
    r[n-i-1] = r[n-i] + distance(x[n-i],y[n-i],x[n-i-1],y[n-i-1])

ans = math.inf
for i in range(1,n-1):
    ans = min(ans, l[i-1] + r[i+1] + distance(x[i-1],y[i-1],x[i+1],y[i+1]))

print(ans)