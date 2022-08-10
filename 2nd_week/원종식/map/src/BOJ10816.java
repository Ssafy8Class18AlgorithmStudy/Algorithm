import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10816 {
    public static void main(String ...args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map=new HashMap<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            int get=Integer.parseInt(st.nextToken());
            if(map.containsKey(get)){
                map.put(get,map.get(get)+1);
            }
            else {
                map.put(get,1);
            }
        }
        StringBuilder ans=new StringBuilder("");
        int m=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int get=Integer.parseInt(st.nextToken());
            if(map.containsKey(get)){
                ans.append(map.get(get)).append(" ");
            }
            else {
                ans.append("0 ");
            }
        }
        System.out.println(ans);
    }

}
