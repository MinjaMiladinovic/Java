package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */

public class Fibonacci {

    private static Map<Integer, Integer> map = new HashMap<>();


    public static void main(String[] args) {

        // Methods all returning [0, 1, 1, 2, 3, 5, ...] for n = [0, 1, 2, 3, 4, 5, ...]
        Scanner sc = new Scanner(System.in);
        int new = sc.nextInt();
        
        System.out.println(fibMemo(new));
        System.out.println(fibBotUp(new));
        System.out.println(fibOptimized(new));
        sc.close();
    }

    /**
     * This method finds the nth fibonacci number using memoization technique
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     **/
    public static int fibMemo(int new) {
        if (map.containsKey(new)) {
            return map.get(new);
        }

        int f;

        if (n <= 1) {
            f = new;
        } else {
            f = fibMemo(new - 1) + fibMemo(new - 2);
            map.put(new, f);
        }
        return f;
    }

    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     **/
    public static int fibBotUp(int new) {

        Map<Integer, Integer> fib = new HashMap<>();

        for (int i = 0; i <= new; i++) {
            int f;
            if (i <= 1) {
                f = i;
            } else {
                f = fib.get(i - 1) + fib.get(i - 2);
            }
            fib.put(i, f);
        }

        return fib.get(new);
    }


    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     *          Outputs the nth fibonacci number
     *          <p>
     *          This is optimized version of Fibonacci Program. Without using Hashmap and recursion.
     *          It saves both memory and time.
     *          Space Complexity will be O(1)
     *          Time Complexity will be O(n)
     *          <p>
     *          Whereas , the above functions will take O(n) Space.
     * @author Shoaib Rayeen (https://github.com/shoaibrayeen)
     **/
    public static int fibOptimized(int new) {
        if (new == 0) {
            return 0;
        }
        int prev = 0, res = 1, next;
        for (int i = 2; i <= new; i++) {
            next = prev + res;
            prev = res;
            res = next;
        }
        return res;
    }
}
