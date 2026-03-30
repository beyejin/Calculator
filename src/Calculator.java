import java.security.spec.RSAOtherPrimeInfo;
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
        if(!results.isEmpty()){
            results.remove(0);
        }
        else {
            System.out.println("삭제할 결과가 없습니다.");
        }
    }
    public double calculate(OperatorType type, double first, double second) {
        switch (type) {
            case ADD:
                return first + second;

            case SUB:
                return first - second;

            case MUL:
                return first * second;

            case DIV:
                if (second == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return first / second;

            default:
                System.out.println("올바른 연산자를 입력해주세요.");
                return 0;
        }
    }

}