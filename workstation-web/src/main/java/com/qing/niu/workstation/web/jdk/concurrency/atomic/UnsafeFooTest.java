package com.qing.niu.workstation.web.jdk.concurrency.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/6/27 16:02
 * @ProjectName communication
 * @Version 1.0.0
 */
public class UnsafeFooTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchFieldException {
//        Simple simple = Simple.class.newInstance();
//        Class.forName("com.qing.niu.workstation.web.jdk.concurrency.atomic.UnsafeFooTest");

        Unsafe unsafe = getUnsafe();
//        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
//        System.out.println(simple.get());
//        System.out.println(simple.getClass());
//        System.out.println(simple.getClass().getClassLoader());

        Guard guard = new Guard();
        guard.work();

        Field field = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
        unsafe.putInt(guard,unsafe.objectFieldOffset(field),42);
        guard.work();

        System.out.println(sizeOf(new Simple()));
    }

    public static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long sizeOf(Object obj){
        Unsafe unsafe = getUnsafe();
        Set<Field> fields = new HashSet<>();
        Class c = obj.getClass();
        while (c != Object.class){
            Field[] delaredFields = c.getDeclaredFields();
            for (Field f : delaredFields){
                if ((f.getModifiers() & Modifier.STATIC) == 0){
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }

        long maxOffSet = 0;
        for (Field field : fields){
            long offSet = unsafe.objectFieldOffset(field);
            if (offSet > maxOffSet){
                maxOffSet = offSet;
            }
        }
        return ((maxOffSet / 8) + 1) * 8;
    }

    static class Guard{
        private int ACCESS_ALLOWED = 1;

        public boolean allow(){
            return 42==ACCESS_ALLOWED;
        }

        public void work(){
            if (allow()){
                System.out.println("working");
            }
        }
    }

    static class Simple{
        private long i = 0;

        private int j = 10;

        static {
            System.out.println("<cinit> ......");
        }

        public Simple(){
            this.i = 1;
            System.out.println("===================");
        }

        public long get(){
            return i;
        }
    }
}
