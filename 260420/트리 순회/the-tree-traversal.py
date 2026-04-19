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
    stack = deque()
    stack.append(root)
    visited = set()
    visited.add(root)

    while stack:
        ch = stack.pop()
        index = ord(ch) - ord("A")
        if left[index] == "." or left[index] in visited:
            ind.append(ch)
            if right[index] != "." and right[index] not in visited:
                stack.append(right[index])
                visited.add(right[index])
        else:
            stack.append(ch)
            stack.append(left[index])
            visited.add(left[index])

def preorder(root):
    q = deque()
    q.append(root)
    visited = set()
    visited.add(root)

    while q:
        ch = q.popleft()
        index = ord(ch) - ord("A")
        if left[index] == "." or left[index] in visited:
            pred.append(ch)
            if right[index] != "." and right[index] not in visited:
                q.append(right[index])
                visited.add(right[index])
        else:
            q.append(ch)
            q.append(left[index])
            visited.add(left[index])

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