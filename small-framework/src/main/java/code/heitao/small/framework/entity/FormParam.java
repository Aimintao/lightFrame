package code.heitao.small.framework.entity;

/**
 * @author Aimin
 * @Title: FormParam
 * @ProjectName lightFrame架构
 * @Description: 封装表单参数
 * @date 2018/6/26 16:30
 */
public class FormParam {
    private String fieldName;
    private Object fieldValue;

    public FormParam(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
