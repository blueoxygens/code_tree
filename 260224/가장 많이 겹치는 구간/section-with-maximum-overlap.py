n = int(input())
intervals = [tuple(map(int, input().split())) for _ in range(n)]

# Please write your code here.
rec = {}
for x1, x2 in intervals:
    for i in range(x1,x2+1):
        if i not in rec:
            rec[i] = 1
        else:
            rec[i] += 1

print(max(list(rec.values())))