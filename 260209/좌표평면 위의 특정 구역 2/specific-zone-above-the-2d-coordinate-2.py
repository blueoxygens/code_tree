n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.

def return_width(x1,y1,x2,y2):
    return abs(x1-x2) * abs(y1-y2)

ans = 160000000000

for i in range (n):
    if i < n-1:
        tx = x[:i]+x[i+1:]
        ty = y[:i]+y[i+1:]
    else:
        tx = x[:i]
        ty = y[:i]
    xmin, xmax, ymin, ymax = 40000, 0,40000, 0
    for j in range(n-1):
        xmin = min(xmin, tx[j]) 
        xmax = max(xmax, tx[j])
        ymin = min(ymin, ty[j])
        ymax = max(ymax, ty[j])
    ans = min(ans, return_width(xmin,ymin,xmax,ymax))

print(ans)