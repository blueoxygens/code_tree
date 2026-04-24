N = int(input())
seat = input()

# Please write your code here.

seat = list(seat)
dic = {}
for i, v in enumerate(seat):
    if v in dic:
        dic[v].append(i)
    else:
        dic[v] = [i]

ans = 0

for plus in dic["0"]:

    rlist = dic["1"][:]
    rlist.append(plus)
    rlist.sort()
    c = N

    for i in range(len(rlist) - 1):
        gap = rlist[i+1] - rlist[i]
        c = min(c, gap)
    
    ans = max(ans, c)
print(ans)