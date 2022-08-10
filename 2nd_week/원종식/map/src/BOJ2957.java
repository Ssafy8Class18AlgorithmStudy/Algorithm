import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2957 {
    static int c=0;
    static class node{
        int now;
        node left=null;
        node right=null;
        public node(int n){
            this.now=n;
        }
        public void insert(int number){
            System.out.println("now " + this.now);
            c++;
            if(number<now){
                if(left!=null){

                    left.insert(now);
                }
                else {
                    System.out.println("left"+number);
                    left=new node(now);
                }
            }
            else if(number>now){
                if(right!=null){
                    right.insert(now);
                }
                else {
                    System.out.println("right"+number);

                    right = new node(now);
                }
            }
        }
    }
    public static void main(String ...args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        node root=new node(Integer.parseInt(br.readLine()));
        System.out.println(c);
        for(int i=1;i<n;i++){
            root.insert(Integer.parseInt(br.readLine()));
            System.out.println(c);
        }
    }
}
