from collections import Counter
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
c = Counter(arr)

target_value = list(c.values())[0]

result = sorted(
    [i for i in c if c[i] == target_value],
    key=lambda x: -int(x)
)

print(' '.join(map(str,result)))
