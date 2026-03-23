import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("---계산기 프로그램---");
        System.out.println("종료를 원하시면 exit를 입력하시오");

        int first,second;

        while (true) {
            int result=0;

            // ✅ 첫 번째 숫자 입력
            while (true) {
                System.out.print("첫번째 양의 정수를 입력하시오: ");
                String input1 = sc.next();

                if (input1.equals("exit")) return;

                try {
                    first = Integer.parseInt(input1);  // 여기서 변환
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }
            // ✅ 두 번째 숫자 입력
            while (true) {
                System.out.print("두번째 양의 정수를 입력하시오: ");
                String input2 = sc.next();

                if (input2.equals("exit")) return;

                try {
                    second = Integer.parseInt(input2);  // 여기서 변환
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("올바르지 않은 입력값입니다.");
                }
            }
            // ✅ 연산자 입력
            System.out.print("연산자를 입력해주세요: ");
            char type = sc.next().charAt(0);

            switch (type) {
                case '+':
                    result = first + second;
                    System.out.println(first+"+"+second+"="+result);
                    break;
                case '-':
                    result = first - second;
                    System.out.println(first+"-"+second+"="+result);
                    break;
                case '/':
                    if(second==0){
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;

                    }
                    result = first / second;
                    System.out.println(first+"/"+second+"="+result);
                    break;

                case '*':
                    result = first * second;
                    System.out.println(first+"*"+second+"="+result);
                    break;
            }

        }


    }

}