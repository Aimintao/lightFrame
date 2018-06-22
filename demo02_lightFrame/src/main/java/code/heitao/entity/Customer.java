package code.heitao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 客户
 */
@Data
public class Customer extends BaseEntity  implements Serializable{

    private static final long serialVersionUID = 5738329289951571954L;
    /**
     * ID
     */
    private long id;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 电话号码
     */
    private String telephone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 备注
     */
    private String remark;
}
