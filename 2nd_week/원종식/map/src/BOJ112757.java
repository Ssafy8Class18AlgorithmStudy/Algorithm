import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ112757 {
    public static void main(String args[]) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder ans=new StringBuilder("");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int get1=Integer.parseInt(st.nextToken());
            int get2=Integer.parseInt(st.nextToken());
            if(get1==1){
                map.put(get2,Integer.parseInt(st.nextToken()));
            }
            if(get1==2){
                int up;
                int down;
                try{
                    up=map.ceilingKey(get2);
                }
                catch (Exception e){
                    up=1000000;
                }
                if(up==get2){
                    map.put(get2,Integer.parseInt(st.nextToken()));
                    continue;
                }

                try{
                    down=map.floorKey(get2);
                }
                catch (Exception e){
                    down=-1000000;
                }
                if(get2-down==up-get2){
                    continue;
                }
                if(get2-down<up-get2){
                    if(get2-down<=K){
                        map.put(down,Integer.parseInt(st.nextToken()));
                    }
                }
                else {
                    if (up - get2 <= K) {
                        map.put(up, Integer.parseInt(st.nextToken()));
                    }
                }
            }
            if(get1==3){
                int up;
                int down;
                try{
                    up=map.ceilingKey(get2);
                }
                catch (Exception e){
                    up=Integer.MAX_VALUE;
                }
                if(up==get2){
                    ans.append(map.get(get2)).append("\n");
                    continue;
                }

                try{
                    down=map.floorKey(get2);
                }
                catch (Exception e){
                    down=Integer.MIN_VALUE;
                }
                if(get2-down==up-get2){
                    if(get2-down<=K){
                        ans.append("?\n");
                    }
                    else {
                        ans.append("-1\n");
                    }
                    continue;
                }
                if(get2-down<up-get2){
                    if(get2-down<=K){
                        ans.append(map.get(down)).append("\n");
                    }
                    else{
                        ans.append("-1\n");
                    }
                    continue;
                }
                else{
                    if(up-get2<=K){
                        ans.append(map.get(up)).append("\n");
                    }
                    else{
                        ans.append("-1\n");
                    }
                    continue;
                }
            }
        }
        System.out.println(ans);
    }


}
