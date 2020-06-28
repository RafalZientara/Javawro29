package pl.com.sda.rafal.zientara.apps.samples.c_operational.interpreter_demo;

public class IntToBinaryExpression implements Expression {

    private int i;

    IntToBinaryExpression(int c){
        this.i=c;
    }
    @Override
    public String interpret(InterpreterContext ic) {
        return ic.getBinaryFormat(this.i);
    }

}
