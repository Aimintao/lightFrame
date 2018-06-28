package code.heitao.small.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Aimin
 * @Title: RequestMapingEntity
 * @ProjectName lightFrame架构
 * @Description: RequestMaping映射到Handle
 * @date 2018/6/26 15:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMaping {
    //注解内方法类型及路径
    String value();
}
