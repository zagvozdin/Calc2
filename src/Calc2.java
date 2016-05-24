
import java.io.File;
import java.util.*;

import static java.lang.Double.NaN;

/**
 * Created by Admin on 12.05.2016.
 */
public class Calc2 {

    // Stack from Java
    private static Stack<Double> stckDbl = new Stack<Double>();

    public static void main(String[] args) {

        Scanner scn = null;

        try {
            if (args.length > 0) {
                scn = new Scanner(new File(args[0]));
            } else {
                scn = new Scanner(System.in);
                System.out.println("Ввод с клаиватуры:");
            }
        } catch (Exception e) {
            System.out.println("Проблема с файлом " + args[0]);
        }

        // scanned line
        String cmdIn;
        // splitted string
        String[] cmdParts;
        // defines
        Map<String, Double> defs = new HashMap<String, Double>();

        // result of Math action
        double tmp;

        // commands
        CmdAdd cmdAdd = new CmdAdd();
        CmdSubtract cmdSubtract = new CmdSubtract();
        CmdMultiply cmdMultiply = new CmdMultiply();
        CmdDivide cmdDivide = new CmdDivide();
        CmdSQRT cmdSQRT = new CmdSQRT();

        // lets's go
        while (true) {
            try {
                cmdIn = scn.nextLine();
            } catch (Exception e) {
                // конец файла
                System.out.println("Окончание вычислений");
                break;
            }
            // empty string, exit
            if (cmdIn.equals("")) break;
//            System.out.println(">>> " + cmdIn);

            cmdParts = cmdIn.split(" ");
            switch (cmdParts[0]) {
                case ("#"):
                    break;
                case ("DEFINE"):
                    if (defs.containsKey(cmdParts[1])) {
                        defs.replace(cmdParts[1], Double.parseDouble(cmdParts[2]));
                    } else {
                        defs.put(cmdParts[1], Double.parseDouble(cmdParts[2]));
                        // System.out.println("put " + cmdParts[1]);
                    }
                    break;
                case ("PUSH"):
                    try {
                        zPush(cmdParts[1]);
                    } catch (Exception e) {
                        if (defs.get(cmdParts[1]) == null) {
                            // System.out.println(cmdParts[1] + " define not found");
                        } else {
                            // System.out.println("define found");
                            zPush(defs.get(cmdParts[1]));
                        }
                    }
                    break;
                case ("POP"):
                    zPop();
                    break;
                case ("PRINT"):
                    try {
                        tmp = zPop();
                        System.out.println(tmp);
                        zPush("" + tmp);
                    } catch (Exception e) {
                    }
                    break;
                case ("+"):
                        cmdAdd.exec(defs,cmdParts,stckDbl);
                    break;
                case ("-"):
                        cmdSubtract.exec(defs,cmdParts,stckDbl);
                    break;
                case ("*"):
                        cmdMultiply.exec(defs,cmdParts,stckDbl);
                    break;
                case ("/"):
                        cmdDivide.exec(defs,cmdParts,stckDbl);
                    break;
                case ("SQRT"):
                        cmdSQRT.exec(defs,cmdParts,stckDbl);
                    break;
                case ("LIST"):
                    System.out.println("LIST command");
                    Object[] arr = (Object [])stckDbl.toArray();
                    for (Object o : arr
                            ) {
                        System.out.println(o.toString());
                    }
                    break;
                default:
                    System.out.println("Нераспознанная команда");
            }
        }
    }


    private static double zPop() {
        try {
            return Double.parseDouble(stckDbl.pop().toString());
        } catch (Exception e) {
            return NaN;
        }
    }

    private static void zPush(double val) {
        stckDbl.push(val);
    }

    private static void zPush(String val) {
        stckDbl.push( Double.parseDouble(val) );
    }


}


