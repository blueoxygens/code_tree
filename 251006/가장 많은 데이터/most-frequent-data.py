from collections import Counter
n = int(input())
words = [input() for _ in range(n)]

# Please write your code here.
c = Counter(words)
print(c.most_common(1)[0][1])