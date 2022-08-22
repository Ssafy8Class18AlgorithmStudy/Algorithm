import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BOJ17472{
    static int[][]map;
    static int islandCount=0;
    static int[][]visit;
    static int Y;
    static int X;
    static int[][] graph;
    public static void dfs(int y,int x){
        visit[y][x]=1;
        map[y][x]=islandCount;
        int dx[]={0,0,-1,1};
        int dy[]={1,-1,0,0};
        for(int d=0;d<4;d++){
            int nx=x+dx[d];
            int ny=y+dy[d];
            if(nx<0||nx>=X||ny<0||ny>=Y) continue;
            if(map[ny][nx]==1&&visit[ny][nx]==0){
                dfs(ny,nx);
            }
        }
    }
    public static void main(String ... args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        Y=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        map=new int[Y][X];
        visit=new int[Y][X];
        for(int i=0;i<Y;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<X;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<Y;i++){
            for(int j=0;j<X;j++){
                if(map[i][j]==1 && visit[i][j]==0){
                    islandCount++;
                    dfs(i,j);
                }
            }
        }
        graph=new int[islandCount+1][islandCount+1];
        // 아래는 섬간 이동을 그래프로 바꿔주는 작업
        for(int i=0;i<Y;i++) {
            int before = -1;
            for (int j = 0; j < X; j++) {
                if (map[i][j] != 0) {
                    if (before == -1) {
                        before = j;
                    } else if (j - before >= 3 && map[i][j] != map[i][before]) {
                        if (graph[map[i][j]][map[i][before]] == 0) {
                            graph[map[i][j]][map[i][before]] = j - before - 1;
                            graph[map[i][before]][map[i][j]] = j - before - 1;
                        } else {
                            graph[map[i][j]][map[i][before]] = Math.min(graph[map[i][j]][map[i][before]], j - before - 1);
                            graph[map[i][before]][map[i][j]] = graph[map[i][j]][map[i][before]];
                        }
                    }
                    before = j;
                }
            }
        }
        for(int j=0;j<X;j++) {
            int before = -1;
            for (int i = 0; i < Y; i++) {
                if (map[i][j] != 0) {
                    if (before == -1) {
                        before = i;
                    } else if (i - before >= 3 && map[i][j] != map[before][j]) {
                        if (graph[map[i][j]][map[before][j]] == 0) {
                            graph[map[i][j]][map[before][j]] = i - before - 1;
                            graph[map[before][j]][map[i][j]] = i - before - 1;
                        } else {
                            graph[map[i][j]][map[before][j]] = Math.min(graph[map[i][j]][map[before][j]], i - before - 1);
                            graph[map[before][j]][map[i][j]] = graph[map[i][j]][map[before][j]];
                        }
                    }
                    before = i;
                }
            }
        }
        int ans=0;
        PriorityQueue<int[]> que=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int visit2[]=new int[islandCount+1];
        int visitCount=1;
        visit2[1]=1;
        for(int i=1;i<islandCount+1;i++){
            if(graph[1][i]!=0){
                que.add(new int[]{i,graph[1][i]});
            }
        }

        while(visitCount<islandCount){
//            System.out.println(que.size());
            while(!que.isEmpty()&&visit2[que.peek()[0]]!=0){
                que.poll();
            }
            if(que.isEmpty()){
                System.out.println(-1);
                return;
            }
            int [] now=que.poll();
            ans+=now[1];
            visit2[now[0]]=1;
            visitCount++;
            for(int i=1;i<islandCount+1;i++){
                if(graph[now[0]][i]!=0){
                    que.add(new int[]{i,graph[now[0]][i]});
                }
            }
        }
        System.out.println(ans);
    }
}