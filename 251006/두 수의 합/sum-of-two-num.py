from collections import Counter

n, k = map(int, input().split())
arr = list(map(int, input().split()))

count = Counter()
pairs = 0

for num in arr:
    complement = k - num
    if count[complement]:
        pairs += count[complement]
    count[num] += 1

print(pairs)
