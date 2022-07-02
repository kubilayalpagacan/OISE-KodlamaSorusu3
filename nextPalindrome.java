// Java program to find next smallest
// palindrome

import java.util.Scanner;

public class nextPalindrome
{

    public static String nextPalindrome(String str){
        int remainder,number=0,backupNumber=0,reverse=0;
        String returnStr="";
        try {
            number=Integer.parseInt(str);
            backupNumber=number;
        }
        catch (NumberFormatException exception){
            System.out.println("Cannot convert to Integer");
            System.exit(0);
        }
        while (backupNumber!=reverse){
            reverse=0;
            number=backupNumber;
            backupNumber++;
            number++;
            while (number!=0){
                remainder=number%10;
                reverse=(reverse*10)+remainder;
                number/=10;
            }
        }
        returnStr=String.valueOf(backupNumber);

        return returnStr;
    }
    public static void main(String[] args)
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Input: ");
        String str=scan.next();
        System.out.println(nextPalindrome(str));
    }
}
