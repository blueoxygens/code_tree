n, m = map(int, input().split())

# Note: Using 1-based indexing for words as per C++ code
words = [""] + [input() for _ in range(n)]
queries = [input() for _ in range(m)]

# Please write your code here.
d = {v:i for i, v in enumerate(words)}
for q in queries:
    if q.isdigit():
        print(words[int(q)])
    else:
        print(d[q])