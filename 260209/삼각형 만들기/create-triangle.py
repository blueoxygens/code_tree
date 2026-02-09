n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

# Please write your code here.
ans = 0
for i in range(n-2):
    for j in range(i+1, n-1):
        if x[i] == x[j]:
            for k in range(j+1,n):
                if y[k] == y[j]:
                    ans = max(ans, abs(x[i]-x[k])*abs(y[k]-y[i]))
        elif y[i] == y[j]:
            for k in range(j+1,n):
                if x[k] == x[j]:
                    ans = max(ans, abs(x[i]-x[k])*abs(y[k]-y[i]))
print(ans)
