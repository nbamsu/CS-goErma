import java.util.Scanner;

public class Class1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter your gender, name  and date of birth with following structure " +
                "gender - your full name - DOB"
        );
        String info=input.nextLine(); // M - yourName - 1995
        System.out.println("Gender is equals to M "+info.startsWith("M"));
        System.out.println("Sting contains the name "+info.contains("Muammer Turan"));
        System.out.println("Your date of birth is "+info.substring(info.length()-5));
        System.out.println("DOB is correct or not? "+info.endsWith("1995"));
        //1-contains method
        //2-endsWith method
        //3-first using substring get the last 4 letters,store them as string then using equals method
        /*M- Muammer Turan -1995
        check first letter is M --> print true
        If the given value contains your name print true.
        Print last 4 letter
        Using equals or endsWith() method check
        last four letter is equals to your exact date of birth or not. Print true or print false. */

    }
}
