n = int(input())
arr = list(map(int, input().split()))

arr.sort(reverse=True)
ans = 0

for i in range(n - 1):
    for j in range(i + 1, n):
        if arr[i] & arr[j] == 0:
            for k in range(j + 1, n):
                if arr[j] & arr[k] == 0 and arr[i] & arr[k] == 0:
                    ans = max(ans, arr[i] + arr[j] + arr[k])
                    break 

print(ans)