import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int K = sc.nextInt();
        int sum = 0;

        for (int i = 0; i < K; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                stack.pop();
            }else {
                stack.push(x);
            }
        }

        while(!stack.isEmpty()) {
            sum = sum + stack.peek();
            stack.pop();
        }
        System.out.println(sum);
    }
}