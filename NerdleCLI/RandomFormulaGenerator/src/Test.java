import org.mariuszgromada.math.mxparser.*;

public class Test {
    public static void main(String[] args) {
        Expression e = new Expression("2+1");
        System.out.println(e.calculate());
    }
}
