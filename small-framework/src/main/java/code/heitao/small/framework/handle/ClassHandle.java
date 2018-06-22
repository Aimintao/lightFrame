package code.heitao.small.framework.handle;

import code.heitao.small.framework.constant.ConfigEnum;
import code.heitao.small.framework.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;

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
    public static Set<Class<?>> classSet;

    static {
        Set<Class<?>> classSet = ClassUtil.getAllClassByPackageName(ConfigEnum.APP_BASE_PACKAGE.getValue());
    }

}
