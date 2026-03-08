arr = list(map(int, input().split()))

# Please write your code here.

abc = max(arr)
arr.sort()
a=arr[0]
b=arr[1]
c = abc -a -b
print(f'{a} {b} {c}')