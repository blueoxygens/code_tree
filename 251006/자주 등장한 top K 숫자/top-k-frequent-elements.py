from collections import Counter
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
c = Counter(arr)
l = sorted(list(c.keys()), key=lambda x: (-c[x], -x))
for i in range(k):
    print(l[i], end=" ")