A, B, C = map(int, input().split())

# Please write your code here.

a = []
b = []
ans = 0

temp = 0
for i in range(3):
    if i == 0:
        while temp < C:
            a.append(temp)
            ans = max(ans, temp)
            temp += A
        temp = 0
    elif i == 1:
        while temp < C:
            b.append(temp)
            ans = max(ans, temp)
            temp += B
        temp = 0
    else:
        for j in range(len(a)):
            for k in range(len(b)):
                if a[j] + b[k] > C:
                    break
                ans = max(ans, a[j] + b[k])

print(ans)
