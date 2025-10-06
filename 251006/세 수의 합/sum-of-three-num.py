n, k = map(int, input().split())
arr = list(map(int, input().split()))

cnt = 0
for i in range(n - 2):
    seen = set()
    target = k - arr[i]
    for j in range(i + 1, n):
        complement = target - arr[j]
        if complement in seen:
            cnt += 1
        seen.add(arr[j])

print(cnt)
