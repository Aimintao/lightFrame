package code.heitao.small.framework.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author Aimin
 * @Title: ReflectionUtil
 * @ProjectName lightFrame架构
 * @Description: 使用反射 实例化ClassHandle 中获取的Bean Class
 * @date 2018/6/25 15:54
 */
@Slf4j
public class ReflectionUtil {

    public static Object newInstance(Class<?> cls) {
        /**
         * @Description: 创建实例
         * @param [cls]
         * @return java.lang.Object
         * @author Aimin
         * @date 2018/6/25 16:14
         */
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (InstantiationException e) {
            log.error("new instance failure", e);
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            log.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }
    public  static Object newInstance(String className){
        /**
         * @Description: 通过类名获取相应的实例
         * @param [className]
         * @return java.lang.Object
         * @author Aimin
         * @date 2018/6/25 16:18
         */
        Class<?> aClass = ClassUtil.loadClass(className);
        return newInstance(aClass);
    }
    public  static Object invokeMethod(Object oj, Method method,Object... args){
      /**
       * @Description: 调用实例方法
       * @param [oj, method, args]
       * @return java.lang.Object
       * @author Aimin
       * @date 2018/6/25 16:26
       */
        Object result;
        method.setAccessible(true);
        try {
            result = method.invoke(oj, args);
        } catch (IllegalAccessException e) {
            log.error("method invoke failure",e);
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            log.error("method invoke failure",e);
            throw new RuntimeException(e);
        }
        return result;
    }
    public  static void  setField(Object object, Field field,Object value){
        /**
         * @Description: 设置成员变量的值
         * @param [object, field, value]
         * @return void
         * @author Aimin
         * @date 2018/6/25 16:34
         */
        try {
            field.setAccessible(true);
            field.set(object,value);
        } catch (IllegalAccessException e) {
            log.error("set field failure",e);
            throw new RuntimeException(e);
        }

    }
}
