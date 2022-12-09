import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.mariuszgromada.math.mxparser.*;

public class Test {
    public static void main(String[] args) {
        Expression e = new Expression("2+1");
        mXparser.consolePrintln("Res: " + e.getExpressionString() + " = " + e.calculate());
    }
}
