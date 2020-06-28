package pl.com.sda.rafal.zientara.apps.samples.c_operational.interpreter_demo;

public class InterpreterMain {

    private InterpreterContext ic;

    private InterpreterMain(InterpreterContext i){
        this.ic=i;
    }

    private String interpret(String str){
        Expression exp; // teraz to null
        //tworzymy zasady dla wyrażeń
        if(str.contains("Hexadecimal")){
            exp=new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else if(str.contains("Binary")){
            exp=new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
        }else return str;

        return exp.interpret(ic);
    }

    public static void main(String args[]){
        String str1 = "2 in Binary";
        String str2 = "2 in Hexadecimal";

        InterpreterMain ec = new InterpreterMain(new InterpreterContext());
        System.out.println(str1+"= "+ec.interpret(str1));
        System.out.println(str2+"= "+ec.interpret(str2));

    }
}
