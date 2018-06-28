package code.heitao.small.framework.entity;

import java.lang.reflect.Method;

/**
 * @author Aimin
 * @Title: HandleMapingEntity
 * @ProjectName lightFrame架构
 * @Description: 封装 Controller类中方法信息
 * @date 2018/6/26 12:05
 */
public class HandleMapingEntity {
    /**
     * Controller 类
     */
    private Class<?> controllerClass;

    /**
     * RequestMaping注解的方法
     */
    private Method mapingMethod;

    public HandleMapingEntity(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.mapingMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getMapingMethod() {
        return mapingMethod;
    }
}
