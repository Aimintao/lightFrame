package code.heitao.small.framework.util;


/**
 * @author Aimin
 * @Title: ArrayUtil
 * @ProjectName lightFrame架构
 * @Description: 数组工具
 * @date 2018/6/26 11:46
 */
public class ArrayUtil {
    public static boolean isEmpty( final Object[] array) {
        /**
         * @Description: 判断数组是否为空
         * @param [objects]
         * @return boolean
         * @author Aimin
         * @date 2018/6/26 11:48
         */
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmpty(final T[] array) {
        /**
         * @Description: 判断数组是否非空
         * @param [array]
         * @return boolean
         * @author Aimin
         * @date 2018/6/26 11:50
         */
        return (array != null && array.length != 0);
    }
}
