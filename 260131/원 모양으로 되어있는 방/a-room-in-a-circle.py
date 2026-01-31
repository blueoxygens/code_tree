import math
n = int(input())
a = [int(input()) for _ in range(n)]

# Please write your code here.
m = math.inf

for i in range(n):
    s = 0
    for j in range(i,i+n):
        s += (j-i)*a[j%n]
    m = min(m,s)

print(m)