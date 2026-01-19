n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = [int(input()) for _ in range(m)]

# Please write your code here.
def b_search(num):
    upper, lower = len(arr)-1, 0
    idx = -1

    while lower <= upper :
        mid = (upper + lower) // 2 
        if arr[mid] == num:
            idx = mid+1
            break
        
        if arr[mid] > num:
            upper = mid-1
        else:
            lower = mid+1

    return idx

for q in queries:
    print(b_search(q))