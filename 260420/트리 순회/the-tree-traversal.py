from collections import deque
n = int(input())

left = [0] * 26
right = [0] * 26

for _ in range(n):
    x, l, r = input().split()
    left[ord(x) - ord("A")] = l
    right[ord(x) - ord("A")] = r

# Please write your code here.
pred = []
ind = []
postd = []

def inorder(root):
    stack = []
    current = root

    while current or stack:
        # 왼쪽 끝까지 내려가며 push
        while current and current != ".":
            stack.append(current)
            idx = ord(current) - ord("A")
            current = left[idx]
        
        # 출력
        current = stack.pop()
        ind.append(current)
        
        # 오른쪽으로 이동
        idx = ord(current) - ord("A")
        current = right[idx]
        if current == ".":
            current = None

def preorder(root):
    stack = [root]

    while stack:
        ch = stack.pop()
        index = ord(ch) - ord("A")
        pred.append(ch)  # 루트 먼저 기록
        
        # 오른쪽을 먼저 push해야 왼쪽이 먼저 pop됨
        if right[index] != ".":
            stack.append(right[index])
        if left[index] != ".":
            stack.append(left[index])

def postorder(root):
    if not root:
        return
    
    stack = [root]
    result = []

    while stack:
        node = stack.pop()
        result.append(node)
        
        index = ord(node) - ord("A")
        # 후위순회의 역순(루트→오→왼)을 만들기 위해
        # 왼쪽을 먼저 push (나중에 꺼내지도록)
        if left[index] != ".":
            stack.append(left[index])
        if right[index] != ".":
            stack.append(right[index])
    
    # result는 현재 루트→오→왼 순서이므로 뒤집으면 후위순회
    postd.extend(reversed(result))

preorder("A")
inorder("A")
postorder("A")

print(''.join(pred))
print(''.join(ind))
print(''.join(postd))