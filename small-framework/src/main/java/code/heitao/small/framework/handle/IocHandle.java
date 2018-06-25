package code.heitao.small.framework.handle;

import code.heitao.small.framework.annotation.Inject;
import code.heitao.small.framework.util.CollectionUtil;
import code.heitao.small.framework.util.ReflectionUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author Aimin
 * @Title: IocHandle
 * @ProjectName lightFrame架构
 * @Description: 实现IOC依赖注入field注解inject
 * @date 2018/6/25 17:28
 */
@Slf4j
public class IocHandle {
    //直接在静态代码块中加载所有的Bean实例
    static {
        //获取所有的bean的class和对应的bean实例
        Map<Class<?>, Object> beanMap = BeanHandle.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            //循环从beanMap中获取bean类和对应的实例，并获取bean类的field
            // 判断如果含有inject注解就setfield反射注入到实例中
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()
                 ){
                Class<?>  beanEntryKey= beanEntry.getKey();
                Object beanEntryValue = beanEntry.getValue();
                //获取bean类中的所有field
                Field[] declaredFields = beanEntryKey.getDeclaredFields();
                for (Field field:declaredFields
                     ) {
                    //判断field中是否含有inject注解
                    if (field.isAnnotationPresent(Inject.class)){
                        //获取field对应的class
                        Class<?> fieldClass = field.getType();
                        //获取实例
                        Object beanFieldClass = beanMap.get(fieldClass);
                        if (beanFieldClass!=null){
                            //set注入到beanEntryKey类的field中
                            ReflectionUtil.setField(beanEntryKey,field,beanFieldClass);
                        }
                    }
                }
            }
        }
    }
}
