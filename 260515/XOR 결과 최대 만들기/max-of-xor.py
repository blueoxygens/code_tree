n, m = map(int, input().split())
A = list(map(int, input().split()))

# Please write your code here.

ans = 0

def backtracking(arr, index):
    global ans
    if len(arr) == m:
        tmp = arr[0]
        for i in range(1,len(arr)):
            tmp ^= arr[i]
        ans = max(tmp, ans)
        return
    for i in range(index, len(A)):
        arr.append(A[i])
        backtracking(arr, i+1)
        arr.pop()

backtracking([],0)

print(ans)
