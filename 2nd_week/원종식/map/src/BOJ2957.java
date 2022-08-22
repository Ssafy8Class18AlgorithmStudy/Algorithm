import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class BOJ2957 {
    public static void main(String ...args) throws IOException {
        long c=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans= new StringBuilder("");
        int n=Integer.parseInt(br.readLine());
        TreeMap<Integer,Integer> map=new TreeMap<>();
        map.put(Integer.MIN_VALUE,-1);
        map.put(Integer.MAX_VALUE,-1);

        for(int i=0;i<n;i++){
            int get=Integer.parseInt(br.readLine());
            int min=map.get(map.floorKey(get));
            int max=map.get(map.ceilingKey(get));
            c+=Math.max(min,max)+1;
            ans.append(c).append("\n");
            map.put(get,Math.max(min,max)+1);
        }
        System.out.println(ans);
    }
}
