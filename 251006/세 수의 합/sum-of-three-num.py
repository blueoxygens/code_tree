from itertools import combinations

n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
#이건 진짜 backtracking이다

ans = combinations(arr,3)

count = 0

for a in ans:
    if sum(a) == k:
        count += 1

print(count)