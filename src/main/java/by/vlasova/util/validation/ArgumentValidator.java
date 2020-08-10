package by.vlasova.util.validation;

import by.vlasova.util.AlphabetHolder;

public class ArgumentValidator {
    private static final int MAX_COUNT_OF_ARGS = 3;

    public static boolean argsValidator(String[] args) {
        if (args == null || args.length == 0 || args.length > MAX_COUNT_OF_ARGS) {
            System.err.println("Invalid number of args");
            return false;
        }
        if (args[0].toLowerCase().equals("be_by")) args[0] = "by";
        if (!AlphabetHolder.locals.contains(args[0].toLowerCase())) {
            System.err.println("Given locale isn't supported");
            return false;
        }
        int value;
        try {
            value = Integer.parseInt(args[1]);
            if (value <= 0) {
                System.err.println("Second argument should be natural number");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("Second argument should be natural number");
            return false;
        }
        if (args.length==3){
            double errRate;
            try{
                errRate = Double.parseDouble(args[2]);
                if (errRate<0){
                    System.err.println("Third argument should be non negative rational number");
                    return false;
                }
            }catch (NumberFormatException e) {
                System.err.println("Third argument should be non negative rational number");
                return false;
            }
        }
        return true;
    }
}