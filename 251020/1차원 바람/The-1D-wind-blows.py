# n, m, q 입력
n, m, q = map(int, input().split())
# building
building = [
    list(map(int, input().split()))
    for _ in range(n)
]
# winds 입력
winds = []
for _ in range(q):
    r, d = input().split()
    r = int(r)
    winds.append((r, d))

# 함수들
# down_simulate(curr_row, curr_dir)
def down_simulate(curr_row, curr_dir):
    
    # 왼쪽으로부터의 바람이면
    if curr_dir == 'L':
        # temp
        temp = building[curr_row][-1]
        # 옮겨주기
        for i in range(m-1, 0, -1):
            building[curr_row][i] = building[curr_row][i-1]
        # temp 넣어주기
        building[curr_row][0] = temp

        # 아래 행이 범위 내이고, 겹치는게 있으면
        if curr_row + 1 < n and is_duplicated(building[curr_row], building[curr_row + 1]):
            # down_simulate
            down_simulate(curr_row + 1, 'R')
    
    # 오른쪽으로부터의 바람이면
    else:
        # temp
        temp = building[curr_row][0]
        # 옮겨주기
        for i in range(m-1):
            building[curr_row][i] = building[curr_row][i+1]
        # temp 넣어주기
        building[curr_row][-1] = temp

        # 아래 행이 범위 내이고, 겹치는게 있으면
        if curr_row + 1 < n and is_duplicated(building[curr_row], building[curr_row + 1]):
            # down_simulate
            down_simulate(curr_row + 1, 'L')


# up_simulate(curr_row, curr_dir)
def up_simulate(curr_row, curr_dir):
    
    # 왼쪽으로부터의 바람이면
    if curr_dir == 'L':
        # temp
        temp = building[curr_row][-1]
        # 옮겨주기
        for i in range(m-1, 0, -1):
            building[curr_row][i] = building[curr_row][i-1]
        # temp 넣어주기
        building[curr_row][0] = temp
        
        # 윗 행이 범위 내이고, 겹치는게 있으면
        if curr_row - 1 >= 0 and is_duplicated(building[curr_row - 1], building[curr_row]):
            # 한번 더 up_simulate
            up_simulate(curr_row - 1, 'R')
    
    # 오른쪽으로부터의 바람이면
    else:
        # temp
        temp = building[curr_row][0]
        # 옮겨주기
        for i in range(m-1):
            building[curr_row][i] = building[curr_row][i+1]
        # temp 넣어주기
        building[curr_row][-1] = temp

        # 윗 행이 범위 내이고, 겹치는게 있으면
        if curr_row - 1 >= 0 and is_duplicated(building[curr_row - 1], building[curr_row]):
            # 한번 더 up_simulate
            up_simulate(curr_row - 1, 'L')

# is_duplicated(arr_1, arr_2)
def is_duplicated(arr_1, arr_2):
    
    # 두 리스트를 돌며
    for i in range(m):
        # 한번이라도 겹치는게 있으면
        if arr_1[i] == arr_2[i]:
            # 성공
            return True
    
    # 없으면 실패
    return False

# simulate(curr_row, curr_dir)
def simulate(curr_row, curr_dir):
    
    # curr_row
    curr_row -= 1

    # 왼쪽으로부터의 바람이면
    if curr_dir == 'L':
        # temp
        temp = building[curr_row][-1]
        # 옮겨주기
        for i in range(m-1, 0, -1):
            building[curr_row][i] = building[curr_row][i-1]
        # temp 넣어주기
        building[curr_row][0] = temp

        # 윗 행이 범위 내이고, 겹치는게 있으면
        if curr_row - 1 >= 0 and is_duplicated(building[curr_row - 1], building[curr_row]):
            # up_simulate
            up_simulate(curr_row - 1, 'R')
        
        # 아래 행이 범위 내이고, 겹치는게 있으면
        if curr_row + 1 < n and is_duplicated(building[curr_row], building[curr_row + 1]):
            # down_simulate
            down_simulate(curr_row + 1, 'R')
        
    # 오른쪽으로부터의 바람이면,
    else:
        # temp
        temp = building[curr_row][0]
        # 옮겨주기
        for i in range(m-1):
            building[curr_row][i] = building[curr_row][i+1]
        # temp 넣어주기
        building[curr_row][-1] = temp

        # 윗 행이 범위 내이고, 겹치는게 있으면
        if curr_row - 1 >= 0 and is_duplicated(building[curr_row-1], building[curr_row]):
            # up_simulate
            up_simulate(curr_row - 1, 'L')

        # 아래 행이 범위 내이고, 겹치는게 있으면
        if curr_row + 1 < n and is_duplicated(building[curr_row], building[curr_row + 1]):
            # down_simulate
            down_simulate(curr_row + 1, 'L')

# 설계
for wind in winds:
    
    # unpacking
    s_row, s_dir = wind

    # simulate
    simulate(s_row, s_dir)

# 출력
for i in range(n):
    for j in range(m):
        print(building[i][j], end=' ')
    print()