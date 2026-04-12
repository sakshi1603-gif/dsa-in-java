import java.util.Scanner;

public class String_Toggle {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char[] arr = str.toCharArray();
        toggle(arr);
    }

    public static void toggle(char[] ch) {
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 65 && ch[i] <= 90) { // A-Z
                ch[i] = (char) (ch[i] + 32);  // uppercase → lowercase
            } else if (ch[i] >= 97 && ch[i] <= 122) { // a-z
                ch[i] = (char) (ch[i] - 32); // lowercase → uppercase
            }
        }
        System.out.print(ch);
    }
}
