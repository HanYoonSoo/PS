import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int num = scan.nextInt();

        System.out.println(str.charAt(num - 1));

    }
}
