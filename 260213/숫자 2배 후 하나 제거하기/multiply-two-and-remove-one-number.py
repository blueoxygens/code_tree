n = int(input())
arr = list(map(int, input().split()))

answer = int(21e8)

for i in range(n):
    arr[i] *= 2
    
    for j in range(n):
        temp = []
        for k in range(n):
            if j == k:
                continue
            temp.append(arr[k])
        
        total = 0
        for k in range(len(temp) - 1):
            total = total + abs(temp[k] - temp[k + 1])
        
        answer = min(answer, total)
    
    arr[i] //= 2

print(answer)