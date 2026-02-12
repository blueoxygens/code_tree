n = int(input())
moves = [tuple(map(int, input().split())) for _ in range(n)]

max_score = 0
for start in range(3):
    cups = [0, 0, 0]
    cups[start] = 1
    score = 0
    
    for a, b, c in moves:
        cups[a-1], cups[b-1] = cups[b-1], cups[a-1]
        score += cups[c-1]
    
    max_score = max(max_score, score)

print(max_score)