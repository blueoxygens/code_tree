n, m = map(int, input().split())
arr = list(map(int, input().split()))
queries = [int(input()) for _ in range(m)]

# Please write your code here.
def find_continuous(num) :
    l, r = 0, len(arr) - 1
    idx = -1
    while l <= r:
        mid = (l+r) // 2
        if arr[mid] == num:
            idx = mid
            break
        
        if arr[mid] > num:
            r = mid -1
        else:
            l = mid + 1
    
    if idx == -1:
        return 0
    
    upper, lower = idx, idx

    while upper < len(arr) and arr[upper] == num:
        upper += 1

    while lower >= 0 and arr[lower] == num:
        lower -= 1
    
    return upper - lower -1

for q in queries:
    print(find_continuous(q))