n, m = map(int, input().split())
numbers = [int(input()) for _ in range(n)]

def compress(numbers):
    tlist = []
    i = 0
    while i < n:
        t = numbers[i]
        count = 1
        while i + count < n and t == numbers[i+count]:
            count += 1
        tlist.append((t, count))
        i += count
    return tlist

def merge(tlist):
    merged = []
    for item in tlist:
        if merged and merged[-1][0] == item[0]:
            merged[-1] = (merged[-1][0], merged[-1][1] + item[1])
        else:
            merged.append(item)
    return merged

tlist = compress(numbers)

while True:
    # 한 루프에서 m 이상인 것 전부 제거
    new_tlist = [(num, c) for num, c in tlist if c < m]
    new_tlist = merge(new_tlist)  # 제거 후 인접 병합
    
    if new_tlist == tlist:  # 변화 없으면 종료
        break
    tlist = new_tlist

print(len(tlist))
if len(tlist) != 0:
    for num, c in tlist:
        print(num)