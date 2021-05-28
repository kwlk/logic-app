package com.logic.app;
import java.io.IOException;
public class App 
{


    public static void main( String[] args ) throws IOException {
        int lengths = args.length;
        if (lengths < 2){
            System.out.println("Wrong amount of arguments, expected LOGIC word, phrase to check " +
                    "and optionally filepath to special characters file in txt format");
            System.exit(1);
        }
        String fileName = null;
        if(lengths == 3){
            fileName = args[2];
        }

        Solution solution = new Solution(new Configuration(args[0], fileName));
        solution.solve(args[1]);
        solution.printSolution();
    }
}
