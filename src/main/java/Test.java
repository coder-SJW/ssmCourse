import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author sjw
 * @Description
 * @Date 14:04 2020/9/20
 **/
public class Test {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int o = 0;
        int csNum = sc.nextInt();
        int[] flag = new int[csNum];
        int n =0;//柜子叔
        int[] m = null;//拿快递叔
        int key = 0;//密码箱位置
        for (int cs = 0; cs < csNum; cs++) {
                n = sc.nextInt();
                m = new int[sc.nextInt()];
                key = sc.nextInt();
            for (int j = 0; j < m.length; j++) {
                m[j] = sc.nextInt();
            }
         //   m =  in.readLine().split(" ");
            int res = key - 1;
            int min = key;
            //右边
            for (int i = 0; i < m.length; i++) {
                if (m[i] > key) {
                    res += 2 * (m[i] - key);
                }
                if (m[i] < min) {
                    min = m[i];
                }
            }
            //左边
            if (min < key) {
                for (int i = 0; i < m.length; i++) {
                    if (m[i] != min && m[i] < key) {
                        res += 2 * (key - m[i]);
                    }
                }
            }
            res += (key-1);
            flag[o] = res;
            o++;
        }
        for(int i = 0;i<csNum;i++){
            System.out.println(flag[i]);
        }
    }
}
