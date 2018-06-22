package framework.service;

import framework.entity.Customer;

import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: CustomerService
 * @ProjectName lightFrame架构
 * @Description: TODO
 * @date 2018/6/14 17:40
 */
public interface CustomerService {
    public List<Customer> getCustomerList();
    public Customer getCustomer(long id);
    public boolean createCustomer(Map<String, Object> fieldMap);
    public boolean updateCustomer(long id, Map<String, Object> fieldMap);
    public boolean deleteCustomer(long id);

}
