n = int(input())
arr1 = list(map(int, input().split()))

m = int(input())
arr2 = list(map(int, input().split()))

# Please write your code here.
a = set(arr1)
ans = []
for i in arr2:
    if i in a:
        ans.append('1')
    else:
        ans.append('0')
print(' '.join(ans))