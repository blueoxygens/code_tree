n = int(input())
arr = list(map(int, input().split()))

# Please write your code here.
total = sum(arr)

if total % 2 == 0:
    dp = [False] * (total//2 + 1)

    for num in arr:
        dp[num] = True

    for num in arr:
        for j in range(total//2, min(arr), -1):
            if dp[j-num]:
                dp[j] = True
    
    if dp[total//2] :
        print("Yes")
    else:
        print("No")
    
else:
    print("No")