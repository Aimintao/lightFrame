package code.heitao.small.framework.handle;

import code.heitao.small.framework.util.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Aimin
 * @Title: BeanHandle
 * @ProjectName lightFrame架构
 * @Description: 根据类名获取类的实例用于注解注入Bean
 * @date 2018/6/25 16:46
 */
@Slf4j
public class BeanHandle {

    public static final Map<Class<?>,Object> BEAN_MAP= new HashMap<Class<?>,Object>();

    static {
        /**
         * @Description: 获取所有Service 和Controller注解的类名.实例MAP
         * @param
         * @return
         * @author Aimin
         * @date 2018/6/25 17:05
         */
        Set<Class<?>> allBeanClassSetFromPackage = ClassHandle.getAllBeanClassSetFromPackage();
        for (Class<?> cls:allBeanClassSetFromPackage
             ) {
            Object instance = ReflectionUtil.newInstance(cls);
            BEAN_MAP.put(cls,instance);
        }
    }

    public static Map<Class<?>,Object> getBeanMap(){
        /**
         * @Description: 获取所有Service 和Controller注解的类名.实例MAP
         * @param []
         * @return java.util.Map<java.lang.Class<?>,java.lang.Object>
         * @author Aimin
         * @date 2018/6/25 17:10
         */
        return BEAN_MAP;
    }
    public  static <E> E getBean( Class<E> cls){
        /**
         * @Description: 获取摸一个Class的实例
         * @param [cls]
         * @return E
         * @author Aimin
         * @date 2018/6/25 17:13
         */
        if (!BEAN_MAP.containsKey(cls)){
            log.error("can not get bean by class:",cls);
            throw new RuntimeException("can not get bean by class:"+cls);
        }
        return (E) BEAN_MAP.get(cls);
    }

    public  static void  setBean(Class<?> cls ,Object object){
        /**
         * @Description: 设置Bean到BEAN_MAP中
         * @param [cls, object]
         * @return void
         * @author Aimin
         * @date 2018/6/25 17:19
         */
        BEAN_MAP.put(cls,object);
    }

}
