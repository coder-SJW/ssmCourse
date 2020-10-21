import java.util.Scanner;

/**
 * @Author sjw
 * @Description
 * @Date 15:13 2020/9/20
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cs = Integer.parseInt(scanner.nextLine());//ceshu
        //scanner.nextLine();
        for(int j = 1; j <= cs;j++){
            int[] a = new int[26];
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                a[str.charAt(i) - 97] += 1;
                //System.out.println(str.charAt(i) - 97);
            }
            int max = a[0];
            for (int i = 1; i < a.length; i++) {
                if (max < a[i]) {
                    max = a[i];
                }
            }
            System.out.println("Case #" + j + ": " + max);
        }
    }

}
