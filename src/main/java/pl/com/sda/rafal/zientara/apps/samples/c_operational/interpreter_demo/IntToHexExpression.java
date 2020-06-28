package pl.com.sda.rafal.zientara.apps.samples.c_operational.interpreter_demo;

public class IntToHexExpression implements Expression {

    private int i;

    IntToHexExpression(int c){
        this.i=c;
    }

    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getHexadecimalFormat(i);
    }

}
