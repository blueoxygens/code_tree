n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
m = 0
for i in range(n-k):
    m = max(m, arr[i]+arr[i+1]+arr[i+2])

print(m)