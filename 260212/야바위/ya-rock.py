n = int(input())
moves = [tuple(map(int, input().split())) for _ in range(n)]
a, b, c = zip(*moves)
a, b, c = list(a), list(b), list(c)

# Please write your code here.
dic = {1:[],2:[],3:[]}
score = [0]*4

def mix(key, a, b, c):
    if dic[key]:
        t = dic[key].pop()
    else:
        t = key

    if t == b:
        dic[key].append(a)
        if a == c:
            score[key] += 1
    elif t == a:
        dic[key].append(b)
        if b == c:
            score[key] += 1
    else:
        dic[key].append(t)
        if t == c:
            score[key] += 1


for i in range(n):
    for k in list(dic.keys()):
        mix(k, a[i], b[i], c[i])

print(max(score))