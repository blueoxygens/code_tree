N = int(input())
a, b, c = map(int, input().split())

# Please write your code here.
total = N ** 3
f,s,t = 0,0,0
for i in range(3):
    if i == 0:
        for j in range(1,N+1):
            if abs(a-j) > 2:
                f += 1
    elif i == 1:
        for j in range(1,N+1):
            if abs(b-j) > 2:
                s += 1
    else:
        for j in range(1,N+1):
            if abs(c-j) > 2:
                t += 1

print(total - f*s*t)
