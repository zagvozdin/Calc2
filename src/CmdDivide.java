import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 19.05.2016.
 */
public class CmdDivide {

    public void exec(Map<String, Double> defs, String[] cmdParts, Stack<Double> stckDbl) {
        // addition with two elements at least
        if ( stckDbl.size()<2 ) {
            System.out.println("Недостатчоно аргументов для деления");
            return;
        }
        stckDbl.push( stckDbl.pop() / stckDbl.pop() );
    }

}
