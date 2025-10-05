from collections import Counter
n, m = map(int, input().split())
arr = list(map(int, input().split()))
nums = list(map(int, input().split()))

# Please write your code here.
c = Counter(arr)
# print(c)
for n in nums:
    print(c[n], end = " ")