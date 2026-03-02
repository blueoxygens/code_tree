# n, m 입력
n, m = map(int, input().split())
# bombs 입력
bombs = [
    int(input())
    for _ in range(n)
]

# 함수들
# get_eliminate_index(curr_bombs)
def get_eliminate_index(curr_bombs):

    # eliminate_index
    eliminate_index = []

    # cnt
    cnt = 1

    for i in range(len(curr_bombs) - 1):

        # 불연속이고, cnt가 m 이상이면
        if curr_bombs[i] != curr_bombs[i+1] and cnt >= m:
            
            # i에서 cnt 전부터 i까지의 인덱스를
            for j in range(i - cnt + 1, i + 1):
                # eliminate_index에 저장
                eliminate_index.append(j)
            # cnt 초기화
            cnt = 1

        # 불연속이고, cnt가 m이하면
        if curr_bombs[i] != curr_bombs[i+1] and cnt < m:
            # cnt 초기화
            cnt = 1

        # 연속이면
        else:
            # cnt 올려주기
            cnt += 1

    # 남은 cnt가 m 이상이면
    if cnt >= m:
        # 마지막에서 cnt 전부터 마지막까지의 인덱스를
        for i in range(len(curr_bombs) - cnt, len(curr_bombs)):
            # eliminate_index에 추가
            eliminate_index.append(i)
    
    # 반환
    return eliminate_index


# 설계
while True:
    
    # m이 1일 경우
    if m == 1:
        # 다터짐
        print(0)
        break

    # m이 1이 아닐 경우
    else:
        # index_to_eleminate -> 터뜨려 줄 인덱스
        index_to_eleminate = get_eliminate_index(bombs)

        # 터뜨려 줄 인덱스가 없으면
        if not len(index_to_eleminate):
            # 출력
            print(len(bombs))
            for bomb in bombs:
                print(bomb)
            # 종료
            break
        
        # 터뜨려 줄 인덱스가 있으면
        else:
            # temp_bombs
            temp_bombs = []

            for i in range(len(bombs)):
                # 제거할 인덱스가 아니면,
                if i not in index_to_eleminate:
                    # temp_bombs에 추가
                    temp_bombs.append(bombs[i])
            
            # bombs 바꿔주기
            bombs = temp_bombs