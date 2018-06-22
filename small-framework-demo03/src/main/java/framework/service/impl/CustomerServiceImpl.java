package framework.service.impl;


import framework.dao.impl.CustomerDAOImpl;
import framework.entity.Customer;
import framework.service.CustomerService;

import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: CustomerServiceImpl
 * @ProjectName lightFrame架构
 * @Description: 提供客户数据服务
 * @Description: 提供客户数据服务
 * @date 2018/6/14 17:37
 */
public class CustomerServiceImpl implements CustomerService{
    private static CustomerDAOImpl customerDaoImpl;
    static {
        customerDaoImpl = new CustomerDAOImpl();
    }
    public List<Customer> getCustomerList() {
        /**
         * @Description: 获取客户列表
         * @param []
         * @return java.util.List<code.heitao.entity.Customer>
         * @author Aimin
         * @date 2018/6/14 17:46
         */
        String sql = "SELECT * FROM customer";
        return customerDaoImpl.queryEntityList(Customer.class,sql);
    }
    public Customer getCustomer(long id) {
        /**
         * @Description: 获取客户
         * @param [id]
         * @return code.heitao.entity.Customer
         * @author Aimin
         * @date 2018/6/14 17:53
         */
        String sql = "SELECT * FROM customer WHERE id = ?";

        return  customerDaoImpl.queryEntity(Customer.class,sql,id);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        /**
         * @Description: 创建客户
         * @param [fieldMap]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 17:54
         */
        return customerDaoImpl.insertEntity(Customer.class,fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
        /**
         * @Description: 更新客户
         * @param [id, fieldMap]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 17:55
         */
        return customerDaoImpl.updateEntity(Customer.class,id,fieldMap);
    }

    public boolean deleteCustomer(long id) {
        /**
         * @Description: 删除客户
         * @param [id]
         * @return boolean
         * @author Aimin
         * @date 2018/6/14 17:56
         */
        return customerDaoImpl.deleteEntity(Customer.class,id);
    }
}