import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Input decimal number
        Scanner scan = new Scanner(System.in);
        System.out.print("Input integer number > 0: ");
        String input = scan.nextLine();

        //Convert to binary
        int decNumber;
        try {
            decNumber = Integer.parseInt(input);
        } catch (NumberFormatException e){
            System.out.println("Inputted not integer");
            return;
        }
        if (decNumber<1) {
            System.out.println("Inputted number < 1 ");
            return;
        }
        String binNumber = toBinary(decNumber);
        System.out.println("BIN: " + binNumber);

        //Create 2 arrays:
        //1. Binary numbers by putting the last digit to the beginning
        String[] arrBinNumbers = new String[binNumber.length()];
        //2. Decimal numbers by converting a corresponding binary number to decimal
        int[] arrDecNumbers = new int[binNumber.length()];

        for (int i=0; i<binNumber.length(); i++)
        {
            arrBinNumbers[i]=binNumber;
            arrDecNumbers[i]=toDec(binNumber);
            System.out.print(arrBinNumbers[i] + " : " + arrDecNumbers[i] + "\n");
            binNumber = binNumber.substring(binNumber.length()-1) + binNumber.substring(0, binNumber.length()-1);
        }
        //Sort array to find the maximum value - the last value will be the biggest
        Arrays.sort(arrDecNumbers);

        System.out.println("The biggest: " + arrDecNumbers[arrDecNumbers.length-1]);
    }

    public static String toBinary(int number){
        if (number==1) return "1";
        else return  toBinary(number/2) + number%2;
    }

    public static int toDec(String number){
        String[] str = number.split("");
        int result=0;
        for (int i=0; i<str.length; i++)
        {
            result = result + (int) Math.pow(2,str.length-i-1) * Integer.parseInt(str[i]);
        }
        return result;
    }
}