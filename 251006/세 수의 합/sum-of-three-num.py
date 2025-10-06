n, k = map(int, input().split())
arr = list(map(int, input().split()))

# Please write your code here.
#이건 진짜 backtracking이다

def find_pairs():
    ans = []
    def bt (start, picked):
        if len(picked) == 3:
            if sum(picked) == k:
                ans.append(tuple(picked))
            return
        
        for i in range(start, n):
            picked.append(i)
            bt(i+1, picked)
            picked.pop()
    
    bt(0, ans)
    return len(ans)

print(find_pairs())