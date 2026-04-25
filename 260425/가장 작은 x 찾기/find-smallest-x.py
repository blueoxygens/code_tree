import math
n = int(input())
ranges = [tuple(map(int, input().split())) for _ in range(n)]
a, b = zip(*ranges)
a, b = list(a), list(b)

# Please write your code here.
lower = 0
upper = math.inf
for i in range(n):
    d = 2**(i+1)
    lower = max(lower, math.ceil(a[i]/(d)))
    upper = min(upper, b[i]//(d))

print(lower)
