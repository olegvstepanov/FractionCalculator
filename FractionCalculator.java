import java.util.*;

public class FractionCalculator {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args){

        introduction();

        while(true){
            String operation = getOperation();
            Fraction frac1 = getFraction();
            Fraction frac2 = getFraction();

            Fraction result_1 = new Fraction(1,1);
            String result_2 = "";

            if (operation.equals("=")){
                System.out.println(frac1+" "+operation+" "+frac2+" is " +frac1.equals(frac2));
            }
            else {
                if(operation.equals("+")){
                    result_1 = frac1.add(frac2);
                }
                else if (operation.equals("-")){
                    result_1 = frac1.subtract(frac2);
                }
                else if (operation.equals("/")){
                    if (frac2.getNumerator() == 0){
                        result_2 = "undefined";
                    }
                    else {
                        result_1 = frac1.divide(frac2);
                    }
                }
                else if (operation.equals("*")){
                    if (frac2.getNumerator() == 0){
                        result_2 = "0";
                    }
                    else {
                        result_1 = frac1.multiply(frac2);
                    }
                }

                if (result_2!=""){
                    System.out.println(frac1+" "+operation+" 0 = " + result_2);
                }
                else if (result_1.getNumerator()%result_1.getDenominator() == 0){
                    System.out.println(frac1+ " "+operation+" "+frac2+" = "+(result_1.getNumerator()/result_1.getDenominator()));
                }
                else {
                    System.out.println(frac1+" "+operation+ " "+frac2+" = "+result_1.toString());
                }

            }
        }

    }

    public static void introduction(){
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type \\\"Q\\\" to quit.");
        System.out.println("Please enter your fraction in the form a/b, where a and b are integers,and b is greater than zero.");
        System.out.println("--------------------------------------------------------------------------------------------");
    }

    public static String getOperation(){

        System.out.println("Please enter an operation (+,-,/,*,=) or \\\"Q\\\" to quit: ");
        String operation = input.nextLine();
        int i = 0;
        while(i ==0){
            if(operation.equalsIgnoreCase("q")){
                System.exit(0);
            }
            else if(operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("=") ){
                i++;
            }
            else {
                System.out.println("Invalid input, enter a valid operation (+,-,/,*,=) or \"Q\" to quit: ");
                operation = input.nextLine();
            }
        }
        return operation;
    }

    public static Fraction getFraction(){
        System.out.println("Please enter a Fraction (a/b) or integer (a): ");
        String userInput = input.nextLine();

        while (!validFraction(userInput)){
            System.out.println("Invalid Fraction, Please enter (a/b) or (a), where a and b are integers and b is greater than zero: ");
            userInput = input.nextLine();
        }

        int num = 0;
        int den = 0;
        if (userInput.contains("/")){
            num = Integer.parseInt(userInput.substring(0,userInput.indexOf("/")));
            den = Integer.parseInt(userInput.substring(userInput.indexOf("/")+1,userInput.length()));
        }
        else {
            num = Integer.parseInt(userInput);
            den = 1;
        }

        Fraction converted = new Fraction(num,den);
        return converted;

    }

    public static boolean validFraction(String fraction){
        boolean valid;

        if (fraction.startsWith("-")){
            fraction = fraction.substring(1,fraction.length());
        }

        if (fraction.contains(" ")||fraction.contains("-")||fraction.charAt(fraction.indexOf("/")+1)==('0')){
            valid = false;
        }
        else if (fraction.contains("/")){
            fraction = fraction.replace("/","");
        }

        if (fraction.matches("[0-9]+")){
            valid = true;
        }
        else{
            valid = false;
        }

        return valid;
    }


}
