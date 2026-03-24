import java.util.ArrayList;

public class Calculator {

    private ArrayList<Double> results = new ArrayList<>();

    public void setResults(double result) {
        results.add(result);
    }
    public ArrayList<Double> getResults() {
        return this.results;
    }

    public void removeResults(){
        results.remove(0);
    }
    public double calculate(char type, double first, double second) {
        switch (type) {
            case '+':
                return first + second;

            case '-':
                return first - second;

            case '/':
                if (second == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    return 0;
                }
                return first / second;

            case '*':
                return first * second;

            default:
                System.out.println("올바른 연산자를 입력해주세요.");
                return 0;
        }
    }

}