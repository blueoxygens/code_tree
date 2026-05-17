n, m = map(int, input().split())

edges = [tuple(map(int, input().split())) for _ in range(m)]

# 높이 순으로 처리
edges.sort(key=lambda x: x[1])

arr = list(range(n))

# 최종 permutation 만들기
for a, b in edges:
    a -= 1
    arr[a], arr[a + 1] = arr[a + 1], arr[a]

# inversion count
answer = 0

for i in range(n):
    for j in range(i + 1, n):
        if arr[i] > arr[j]:
            answer += 1

print(answer)