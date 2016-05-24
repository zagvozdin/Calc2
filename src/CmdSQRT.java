import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 18.05.2016.
 */
public class CmdSQRT {

    public void exec(Map<String, Double> defs, String[] cmdParts, Stack<Double> stckDbl) {
        // addition with two elements at least
        if ( stckDbl.size()<1 ) {
            System.out.println("Недостатчоно аргументов для извлечения квадратного корня");
            return;
        }
        stckDbl.push( Math.sqrt(stckDbl.pop()) );
    }

}


