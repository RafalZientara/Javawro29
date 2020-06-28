package pl.com.sda.rafal.zientara.apps.samples.c_operational.interpreter_demo;

class InterpreterContext {

    String getBinaryFormat(int i){
        return Integer.toBinaryString(i);
    }

    String getHexadecimalFormat(int i){
        return Integer.toHexString(i);
    }
}
