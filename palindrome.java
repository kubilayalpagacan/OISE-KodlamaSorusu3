import java.math.BigInteger;
import java.util.Scanner;

public class palindrome {
    public static String findPalindrome(String str) {

        try {
            BigInteger INPUT = new BigInteger(str);
            String emptyNewString = "";
            if (str.length() == 1) { // if str is in range 0-9
                int in=INPUT.intValue();
                emptyNewString += 11;
                System.out.println("Palindrome: 11");
                System.out.println("Eklenmesi gereken deger: "+(11-in));
                return emptyNewString;
            }
            if (allNine(str)) { // if all elements of str is "9"
                emptyNewString += 1;
                for (int i = 0; i < str.length() - 1; i++) {
                    emptyNewString += 0;
                }
                emptyNewString += 1;
                System.out.println("Palindrome: "+emptyNewString);
                System.out.println("Eklenmesi gereken deger: 2");
                return emptyNewString;
            }
            if (str.length() % 2 == 0) { // if number length is even
                int x = Character.getNumericValue(str.charAt(str.length() / 2)); //  midNumber
                int y = Character.getNumericValue(str.charAt((str.length() / 2) - 1)); //  midNumber-1
                if (x > y) { // midNumber>midNumber-1
                    StringBuilder builderString = new StringBuilder(str);
                    builderString.setCharAt(((str.length() / 2) - 1), str.charAt(str.length() / 2));
                    String t = addingCharToStringEven(builderString, emptyNewString);
                    subsract(t, str);

                } else if (x < y) { // midNumber<midNumber-1
                    StringBuilder builderString = new StringBuilder(str);
                    builderString.setCharAt(((str.length() / 2)), str.charAt((str.length() / 2) - 1));
                    String t = addingCharToStringEven(builderString, emptyNewString);
                    subsract(t, str);
                } else { // midNumber==midNumber-1
                    int i = (str.length() / 2); // midNumber position
                    int j = (str.length() / 2) - 1; // midNumber-1 position
                    int count = 0; // count iteration
                    int z = Character.getNumericValue(str.charAt(i)); // midNumber int value
                    while (str.charAt(i) == str.charAt(j)) { // if values are same
                        i++; // increasing one of them
                        j--; // decreasing one of them
                        count++;
                        if (i > str.length() || j < 0) { // if i or j is out of bounds
                            z++; //increasing z by 1
                            StringBuilder builderString = new StringBuilder(str);
                            builderString.setCharAt((str.length() / 2), Character.forDigit(z, 10)); //changing
                            builderString.setCharAt((str.length() / 2 - 1), Character.forDigit(z, 10));
                            String t = addingCharToStringEven(builderString, emptyNewString);
                            subsract(t, str);
                            return emptyNewString;
                        }
                    }
                    if (str.charAt(i) > str.charAt(j)) { // if midNumber no longer equal to midNumber-1 and
                        StringBuilder builderString = new StringBuilder(str); // midNumber>midNumber-1
                        builderString.setCharAt(((str.length() / 2) - (1 + count)), str.charAt((str.length() / 2) + count));
                        String t = addingCharToStringEven(builderString, emptyNewString);
                        subsract(t, str);
                    } else if (str.charAt(i) < str.charAt(j)) { // if midNumber no longer equal to midNumber-1 and
                        StringBuilder builderString = new StringBuilder(str); //midNumber<midNumber-1
                        builderString.setCharAt(((str.length() / 2)), str.charAt((str.length() / 2) - 1));
                        String t = addingCharToStringEven(builderString, emptyNewString);
                        subsract(t, str);
                    }
                }
            } else { // if length is odd
                int x = Character.getNumericValue(str.charAt(str.length() / 2 + 1)); // midNumber+1
                int y = Character.getNumericValue(str.charAt(str.length() / 2 - 1)); // midNumber-1
                if (x > y) { // midNumber+1>midNumber-1
                    StringBuilder builderString = new StringBuilder(str);
                    builderString.setCharAt(((str.length() / 2 - 1)), str.charAt((str.length() / 2 + 1)));
                    String t = addingCharToStringOdd(builderString, emptyNewString);
                    subsract(t, str);
                } else if (x < y) { // midNumber+1>midNumber-1
                    StringBuilder builderString = new StringBuilder(str);
                    builderString.setCharAt(((str.length() / 2 + 1)), str.charAt((str.length() / 2 - 1)));
                    String t = addingCharToStringOdd(builderString, emptyNewString);
                    subsract(t, str);
                } else { // midNumber+1==midNumber-1
                    int i = (str.length() / 2) + 1; // midNumber+1 position
                    int j = (str.length() / 2) - 1; // midNumber-1 position
                    int count = 0; // count iteration
                    int z = Character.getNumericValue(str.charAt(i)); // integer value of midNumber+1

                    while (str.charAt(i) == str.charAt(j)) {  // if values are same
                        i++; // increasing midNumber+1
                        j--; // decreasing midNumber-1
                        count++;
                        if (i > str.length() || j < 0) { // break while and set chars
                            z++;
                            StringBuilder builderString = new StringBuilder(str);
                            builderString.setCharAt((str.length() / 2), Character.forDigit(z, 10));
                            String t = addingCharToStringOdd(builderString, emptyNewString);
                            subsract(t, str);
                            return emptyNewString;
                        }
                    }
                    if (str.charAt(i) > str.charAt(j)) { // midNumber+1 > midNumber-1
                        StringBuilder builderString = new StringBuilder(str);
                        builderString.setCharAt(((str.length() / 2) - (1 + count)), str.charAt((str.length() / 2 + 1) + count));
                        String t = addingCharToStringOdd(builderString, emptyNewString);
                        subsract(t, str);
                    } else if (str.charAt(i) < str.charAt(j)) { // midNumber+1 < midNumber-1
                        StringBuilder builderString = new StringBuilder(str);
                        builderString.setCharAt(((str.length() / 2 + 1) + count), str.charAt((str.length() / 2) - (1 + count)));
                        String t = addingCharToStringOdd(builderString, emptyNewString);
                        subsract(t, str);
                    }
                }
            }
        } catch (NumberFormatException exception) {
            System.out.println("Exception: Cannot convert to Integer");
            System.exit(0);
        }
        return str;
    }

    public static boolean allNine(String str) { //checking nines
        char[] stringChars = str.toCharArray();
        for (int i = 0; i < str.length(); i++)
            if (stringChars[i] != '9')
                return false;
        return true;
    }


    public static String addingCharToStringEven(StringBuilder builderString, String emptyNewString) {
        for (int i = 0; i < (builderString.length() / 2); i++) {
            emptyNewString += builderString.charAt(i);
        }
        for (int i = (builderString.length() / 2) - 1; i >= 0; i--) {
            emptyNewString += builderString.charAt(i);
        }
        System.out.println("Palindrome: " + emptyNewString);
        return emptyNewString;
    }

    public static String addingCharToStringOdd(StringBuilder builderString, String emptyNewString) {
        for (int i = 0; i < (builderString.length() / 2); i++) {
            emptyNewString += builderString.charAt(i);
        }
        emptyNewString += builderString.charAt(builderString.length() / 2);
        for (int i = (builderString.length() / 2) - 1; i >= 0; i--) {
            emptyNewString += builderString.charAt(i);
        }
        System.out.println("Palindrome:" + emptyNewString);
        return emptyNewString;
    }

    public static String subsract(String str1, String str2) { //substraction method
        BigInteger A = new BigInteger(str1);
        BigInteger B = new BigInteger(str2);

        BigInteger C = A.subtract(B);
        String z = C.toString();
        System.out.println("Eklenmesi gereken deger: " + z);

        return z;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number");
        String str = scan.next();
        findPalindrome(str);


    }
}
