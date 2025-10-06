from collections import Counter

n, k = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
for i in range(n - 2):
    seen = Counter()
    target = k - arr[i]
    for j in range(i + 1, n):
        complement = target - arr[j]
        cnt += seen[complement]
        seen[arr[j]] += 1

print(cnt)
