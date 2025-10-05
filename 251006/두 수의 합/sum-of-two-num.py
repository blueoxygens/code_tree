from collections import Counter
n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
#Backtracking으로 할까 걍
ans = []
def p():
    def backtracking(start, a):
        if len(a) == 2:
            if sum(a) == k:
                ans.append(tuple(a))
        for i in range(start, n-1):
            a.append(arr[i])
            b = backtracking(i+1, a)
            a.pop()
    backtracking(0,[])
p()
print(len(ans))