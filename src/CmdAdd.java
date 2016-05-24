import org.codehaus.groovy.runtime.powerassert.SourceText;

import java.util.Map;
import java.util.Stack;

/**
 * Created by zag on 18.05.2016.
 */
public class CmdAdd {

    public void exec(Map<String, Double> defs, String[] cmdParts, Stack<Double> stckDbl) {
        // addition with two elements at least
        if ( stckDbl.size()<2 ) {
            System.out.println("Недостатчоно аргументов для сложения");
            return;
        }
        stckDbl.push( stckDbl.pop() + stckDbl.pop() );
    }

}


