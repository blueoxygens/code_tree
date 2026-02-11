abilities = list(map(int, input().split()))

# Please write your code here.
cand = []
def backtracking(arr, start):
    if len(arr) == 3:
        cand.append(arr[:])
        return
    for i in range(start,6):
        arr.append(abilities[i])
        backtracking(arr,i+1)
        arr.pop()
total = sum(abilities)
backtracking([],0)
ans = 100000000000000
for a in cand:
    b = sum(a)
    c = total - b
    ans =min(ans, abs(b-c))
print(ans)