import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int[] ans;

    static void bfs(int node, Map<Integer, ArrayList<Integer>> hash){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.addLast(new int[] {node,0});
        visited[node] = true;
        
        while(!q.isEmpty()){
            int[] from = q.pollFirst();
            if(!hash.containsKey(from[0])) continue;
            int l = hash.get(from[0]).size();

            for(int i =0; i < l; i++){
                int to =  hash.get(from[0]).get(i);
                if(visited[to]) continue;
                q.addLast(new int[] {to, from[1]+1});
                ans[to] = Math.max(ans[to], from[1]+1);
                visited[to] = true;
            }
        }

        for(int i = 0 ; i < n+1; i++){
            if(!visited[i] && i != node){
                ans[i] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] edge = new int[m][];
        for(int i = 0; i < m; i++){
            edge[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] departure = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 출발지 -> 도착지
        Map<Integer, ArrayList<Integer>> hash = new HashMap<>();
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> list = hash.getOrDefault(edge[i][0], new ArrayList<>());
            list.add(edge[i][1]);
            hash.put(edge[i][0], list);
        }

        // 각 노드마다 가장 오래걸리는 사람의 시간을 기록, 여기서 최솟값 도출
        ans = new int[n+1];

        for(int node : departure){
            bfs(node, hash);
        }

        System.out.println(
            Arrays.stream(ans).filter(x -> x >0 && x < Integer.MAX_VALUE).min().orElse(-1)
        );
    }
}