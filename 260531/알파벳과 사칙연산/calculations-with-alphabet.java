import java.io.*;
import java.util.*;

public class Main {

    static int n = 0;
    static ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

    static void backtracking(ArrayDeque<Integer>arr){
        if(arr.size() == n){
            combinations.add(new ArrayList<>(arr));
            return;
        }
        for(int i = 1; i < 5; i++){
            arr.addLast(i);
            backtracking(arr);
            arr.pollLast();
        }
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        Set<Character> operator = new HashSet<>(Arrays.asList('+','-','*'));
        Set<Character> variables = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();

        // backtracking 돌려서 조합 만들고
        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (!operator.contains(c)){
                variables.add(c);
            }
        }
        
        n = variables.size();

        int index = 0;

        for (char c : variables){
            map.put(c,index++);
        }

        backtracking(new ArrayDeque<>());

        int ans = Integer.MIN_VALUE; 

for (ArrayList<Integer> arr : combinations) {
    // 1. 맨 첫 번째 숫자를 먼저 temp에 넣고 시작합니다. (예: A+B 에서 A)
    int temp = arr.get(map.get(expression.charAt(0)));
    
    // 2. 인덱스 1부터 2씩 건너뛰며 탐색합니다. (연산자만 쏙쏙 골라냄)
    for (int i = 1; i < expression.length(); i += 2) {
        char op = expression.charAt(i); // 현재 연산자 (+, -, *)
        
        // 연산자 바로 다음 칸(i + 1)에 있는 글자가 다음 변수입니다.
        int nextVal = arr.get(map.get(expression.charAt(i + 1))); 
        
        if (op == '+') {
            temp += nextVal;
        } else if (op == '-') {
            temp -= nextVal;
        } else if (op == '*') {
            temp *= nextVal;
        }
    }
    
    // 최댓값 갱신
    ans = Math.max(ans, temp);
}
System.out.println(ans);
    }
}