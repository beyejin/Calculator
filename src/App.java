import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator<Double> cal = new Calculator<>();

        System.out.println("---계산기 프로그램---");
        System.out.println("종료를 원하시면 exit를 입력하시오");

        while (true) {
            double first;
            double second;

            while (true) {
                System.out.print("첫번째 수를 입력하시오: ");
                String input1 = sc.next();

                if (input1.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
                try {
                    first = Double.parseDouble(input1);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }

            while (true) {
                System.out.print("두번째 수를 입력하시오: ");
                String input2 = sc.next();

                if (input2.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
                try {
                    second = Double.parseDouble(input2);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }

            System.out.print("연산자를 입력해주세요(+, -, *, /): ");
            String opInput = sc.next();

            if (opInput.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;
            }

            if (opInput.length() != 1) {
                System.out.println("올바른 연산자를 입력해주세요.");
                continue;
            }

            OperatorType operator;
            try {
                operator = OperatorType.fromChar(opInput.charAt(0));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                double result = cal.calculate(operator, first, second);
                cal.setResults(result);
                System.out.println(first + " " + operator.getSymbol() + " " + second + " = " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            ArrayList<Double> results = cal.getResults();
            System.out.println("목록: " + results);

            while (true) {
                System.out.print("제일 오래된 값 삭제를 원합니까? (y/n): ");
                char rmInput = sc.next().charAt(0);

                switch (rmInput) {
                    case 'y':
                    case 'Y':
                        cal.removeResults();
                        results = cal.getResults();
                        System.out.println("삭제 완료 " + results);
                        break;

                    case 'n':
                    case 'N':
                        System.out.println("삭제를 진행하지 않습니다.");
                        break;

                    default:
                        System.out.println("올바른 값을 입력해주세요. (y/n)");
                        continue;
                }
                break;
            }
        }
    }
}