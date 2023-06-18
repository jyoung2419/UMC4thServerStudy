//EvenOdd 클래스
public class EvenOdd {
    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

//main 클래스
public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (EvenOdd.isEven(i)) {
                System.out.println(i);
            }
        }
    }
}
