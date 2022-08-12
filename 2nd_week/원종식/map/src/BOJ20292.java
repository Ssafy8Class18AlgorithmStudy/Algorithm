import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ20292 {
    public static void main(String ...asmr) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ans=new StringBuilder("");
        Set<String> hashR=new HashSet<>();
        Set<String> hashW=new HashSet<>();

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
                if(hashW.contains(a)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                else if(hashW.contains(b)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                else if(hashR.contains(b)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                ans.append(get).append("\n");
                hashR.add(a);
                hashW.add(b);
            }
            else {
                String a=st.nextToken();
                if(hashW.contains(a)){
                    ans.append("WAIT\n");
                    hashR.clear();
                    hashW.clear();
                }
                ans.append(get).append("\n");
                hashR.add(a);
            }
        }
    }
}
