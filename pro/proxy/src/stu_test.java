import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class stu_test extends stu {
    public static void main(String[] args) {
        stu s = new stu();
        stu_interface d = (stu_interface) Proxy.newProxyInstance(s.getClass().getClassLoader(), new Class[]{stu_interface.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("eat")) {
                    return method.invoke(s, args);
                } else {
                    System.out.println("在黑马自习");
                }
                return null;
            }
        });
        d.eat("sssss");
        d.study();
    }

}
