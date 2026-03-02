# from collections import deque
n, m = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

# Please write your code here.
def compress(numbers):
    tlist = []
    i = 0
    while i < n:
        t = numbers[i]
        count = 1
        while i + count < n and t == numbers[i+count]:
            count += 1
        tlist.append((t,count))
        i += count
    return tlist

def delete(tlist, target):
    #case 1. index = 0
    if target == 0:
        if len(tlist) == 1:
            return []
        return tlist[1:]
    #case 2. 0<index<len(tlist)
    elif 0<target<len(tlist)-1:
        n1, c1 = tlist[target-1]
        n2, c2 = tlist[target+1]
        if n1 == n2:
            if target + 2 <len(tlist):
                return tlist[:target-1]+[(n1,c1+c2)]+tlist[target+2:]
            else:
                return tlist[:target-1]+[(n1,c1+c2)]
        else:
            return tlist[:target] + tlist[target+1:]
    #case 3. index = len(tlist)-1
    else:
        return tlist[:target]

tlist = compress(numbers)

start = 0
while start < len(tlist):
    num, c = tlist[start]
    if c >= m:
        tlist = delete(tlist, start)
        start = max(0, start - 1) 
        continue
    start += 1

print(len(tlist))
if len(tlist) != 0:
    for num, c in tlist:
        print(num)