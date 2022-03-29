import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.math.BigDecimal;

public class solver {
  public static int get_answer (String equation) throws ScriptException {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    //String answer = engine.eval(foo);
    //see if can remove BigDecimal
    return new BigDecimal(engine.eval(equation).toString()).intValue();
    //System.out.println();
    
    } 
}