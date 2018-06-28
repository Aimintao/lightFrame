package code.heitao.small.framework.entity;

/**
 * @author Aimin
 * @Title: Data
 * @ProjectName lightFrame架构
 * @Description: 封装Json返回数据
 * @date 2018/6/26 16:19
 */
public class Data {
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }
}
