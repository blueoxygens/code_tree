n, m = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
ans = 0
i = 0
while i < n:
    if arr[i] == 1:
        i += 2*m+1
        ans += 1

print(ans)