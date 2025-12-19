K, N = map(int, input().split())

# Please write your code here.
ans = []

def backtracking(arr):
    if len(arr) >= 3:
        l = len(arr)
        if arr[l-3]==arr[l-2] == arr[l-1]:
            return

    if len(arr) == N:
        ans.append(arr[:])
        return

    for i in range(1,K+1):
        arr.append(i)
        backtracking(arr)
        arr.pop()
arr = []
backtracking(arr)

for i in ans:
    print(*i)