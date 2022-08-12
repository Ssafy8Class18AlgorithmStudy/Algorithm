import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20292 {
    public static void main(String ...asmr) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans=new StringBuilder("");
        HashMap<String,Integer> hashR=new HashMap<>();
        HashMap<String,Integer> hashW=new HashMap<>();
        while (true){
            String get=br.readLine();
            if(get.equals("EXIT")){
                System.out.println(ans.append("EXIT"));
                return;
            }
            StringTokenizer st=new StringTokenizer(get);
            if(st.nextToken().equals("WRITE")){
                String a=st.nextToken();
                st.nextToken();
                String b=st.nextToken();
                if(hashW.containsKey(a)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                else if(hashW.containsKey(b)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                else if(hashR.containsKey(b)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                ans.append(get).append("\n");
                hashR.put(a,1);
                hashW.put(b,1);
            }
            else {
                String a=st.nextToken();
                if(hashW.containsKey(a)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                ans.append(get).append("\n");
                hashR.put(a,1);
            }
        }
    }
}
