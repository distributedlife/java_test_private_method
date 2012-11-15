import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassTest {
    @Test
    public void myMethodReturns56() {
        MyClass myClass = new MyClass();

        Method method = null;
        Integer result = 0;
        try {
            method = MyClass.class.getDeclaredMethod("myMethod");
            method.setAccessible(true);
            result = (Integer) method.invoke(myClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Assert.that(result == 56, "bam!");
    }
}
