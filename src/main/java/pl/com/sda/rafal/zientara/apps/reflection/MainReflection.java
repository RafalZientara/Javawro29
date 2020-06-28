package pl.com.sda.rafal.zientara.apps.reflection;

import java.lang.reflect.Field;

public class MainReflection {

    public static void main(String[] args) {
        Data data = new Data();
        Class<? extends Data> cls = data.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            Object obj = getValue(data, field);
            System.out.println(field.getName() + " = " + obj);
        }
    }

    private static Object getValue(Data data, Field field) {
        try {
            field.setAccessible(true);
            return field.get(data);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
