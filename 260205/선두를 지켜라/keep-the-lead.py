import sys

def solve():
    # 입력을 빠르게 읽어옵니다.
    input_data = sys.stdin.read().split()
    if not input_data: return
    
    n, m = int(input_data[0]), int(input_data[1])
    
    # 각 시간별 위치를 저장할 리스트 (최대 시간 합만큼)
    pos_a = [0]
    pos_b = [0]
    
    curr = 2
    # A의 이동 경로 복원
    for _ in range(n):
        v, t = int(input_data[curr]), int(input_data[curr+1])
        for _ in range(t):
            pos_a.append(pos_a[-1] + v)
        curr += 2
        
    # B의 이동 경로 복원
    for _ in range(m):
        v, t = int(input_data[curr]), int(input_data[curr+1])
        for _ in range(t):
            pos_b.append(pos_b[-1] + v)
        curr += 2

    # 선두 변화 체크
    leader = 0 # 0: 동점, 1: A가 선두, 2: B가 선두
    changes = 0
    
    # 0초(시작점)를 제외하고 1초부터 비교
    for t in range(1, len(pos_a)):
        if pos_a[t] > pos_b[t]:
            # 이전 선두가 B였다면 변화 발생
            if leader == 2:
                changes += 1
            leader = 1
        elif pos_b[t] > pos_a[t]:
            # 이전 선두가 A였다면 변화 발생
            if leader == 1:
                changes += 1
            leader = 2
            
    print(changes)

if __name__ == "__main__":
    solve()