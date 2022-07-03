import java.util.Scanner;

public class Main {

    public static String pw = "";
    public static int length = 0;

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        System.out.println("Masukkan password (hanya huruf): ");
        pw = "" + scan.nextLine();
        length = pw.length();

        runner();
    }

    public static void runner(){
        PassCrack p0 = new PassCrack();
        PassCrack p1 = new PassCrack();

        Thread t0 = new Thread(p0);
        Thread t1 = new Thread(p1);

        t0.start();
        t1.start();
    }
}
