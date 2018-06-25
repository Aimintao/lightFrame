package code.heitao.small.framework.handle;

import code.heitao.small.framework.annotation.Controller;
import code.heitao.small.framework.annotation.Service;
import code.heitao.small.framework.constant.ConfigEnum;
import code.heitao.small.framework.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aimin
 * @Title: ClassHandle
 * @ProjectName lightFrame架构
 * @Description: 用来管理指定包下的所有类
 * @date 2018/6/21 18:39
 */
@Slf4j
public class ClassHandle {
    public static Set<Class<?>> CLASS_SET;

    static {
        CLASS_SET = ClassUtil.getAllClassByPackageName(ConfigEnum.APP_BASE_PACKAGE.getValue());
    }
    public  static Set<Class<?>> getAllClassSetFromPackage(){
        /**
         * @Description: 获取应用包名下的所有类
         * @param []
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/25 14:05
         */
        return  CLASS_SET;
    }
    public  static Set<Class<?>> getAllControllerClassSetFromPackage(){
        /**
         * @Description: 获取应用包名下所有 Controller 类
         * @param []
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/25 14:05
         */
        HashSet<Class<?>> controllerSet = new HashSet<Class<?>>();
        for (Class<?> cls :CLASS_SET
             ) {
           if (cls.isAnnotationPresent(Controller.class)){
              controllerSet.add(cls);
           }
        }
        return  controllerSet;
    }
    public  static Set<Class<?>> getAllServiceClassSetFromPackage(){
        /**
         * @Description: 获取应用包名下所有 Service 类
         * @param []
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/25 14:05
         */
        HashSet<Class<?>> serviceSet = new HashSet<Class<?>>();
        for (Class<?> cls :CLASS_SET
             ) {
           if (cls.isAnnotationPresent(Service.class)){
               serviceSet.add(cls);
           }
        }
        return  serviceSet;
    }
    public  static Set<Class<?>> getAllBeanClassSetFromPackage(){
        /**
         * @Description: 获取应用包名下所有 Bean 类（包括：Service、Controller 等）
         * @param []
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/25 14:05
         */
        HashSet<Class<?>> beanSet = new HashSet<Class<?>>();
        beanSet.addAll(getAllControllerClassSetFromPackage());
        beanSet.addAll(getAllServiceClassSetFromPackage());
        return  beanSet;
    }

    public static Set<Class<?>> getAllChildClassSetFromPackage(Class<?> superClass) {
        /**
         * @Description: 获取应用包名下某父类（或接口）的所有子类（或实现类）
         * @param [superClass]
         * @return java.util.Set<java.lang.Class<?>>
         * @author Aimin
         * @date 2018/6/25 15:38
         */
        HashSet<Class<?>> childSet = new HashSet<Class<?>>();
        for (Class<?> cls:CLASS_SET
             ) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)){
                childSet.add(cls);
            }
        }
        return childSet;
    }
 public static Set<Class<?>> getAllClassSetFromPackageSomeOneAnnotation(Class<? extends Annotation> annotation) {
       /**
        * @Description: 获取应用包名下带有某注解的所有类
        * @param [annotation]
        * @return java.util.Set<java.lang.Class<?>>
        * @author Aimin
        * @date 2018/6/25 15:45
        */
        HashSet<Class<?>> someOneAnnotationClassSet = new HashSet<Class<?>>();
        for (Class<?> cls:CLASS_SET
             ) {
            if (cls.isAnnotationPresent(annotation)){
                someOneAnnotationClassSet.add(cls);
            }
        }
        return someOneAnnotationClassSet;
    }



}
