n = int(input())
points = [tuple(map(int, input().split())) for _ in range(n)]
x = [p[0] for p in points]
y = [p[1] for p in points]

ans = 0
for i in range(n-2):
    for j in range(i+1, n-1):
        if x[i] == x[j]:  # Points i and j share the same x-coordinate (vertical edge)
            for k in range(j+1, n):
                if y[k] == y[j]:  # Points j and k share the same y-coordinate (horizontal edge)
                    # Rectangle formed: (x[i], y[i]), (x[i], y[j]), (x[j], y[k]), (x[k], y[k])
                    # Width: |x[k] - x[i]|, Height: |y[j] - y[i]|
                    ans = max(ans, abs(x[k] - x[i]) * abs(y[j] - y[i]))
        elif y[i] == y[j]:  # Points i and j share the same y-coordinate (horizontal edge)
            for k in range(j+1, n):
                if x[k] == x[j]:  # Points j and k share the same x-coordinate (vertical edge)
                    # Rectangle formed: (x[i], y[i]), (x[j], y[i]), (x[j], y[k]), (x[i], y[k])
                    # Width: |x[j] - x[i]|, Height: |y[k] - y[i]|
                    ans = max(ans, abs(x[j] - x[i]) * abs(y[k] - y[i]))
print(ans)