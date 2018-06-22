package code.heitao.test;

import code.heitao.base.BaseDAOImpl;
import code.heitao.entity.Customer;
import code.heitao.service.CustomerService;
import code.heitao.service.impl.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Aimin
 * @Title: CustomerServiceTest
 * @ProjectName lightFrame架构
 * @Description: 客户单元接口测试
 * @date 2018/6/13 18:49
 */
@Slf4j
public class CustomerServiceTest extends  BaseDAOImpl<Customer>{
    private final CustomerService customerService;


    public CustomerServiceTest() {
        customerService = new CustomerServiceImpl();
    }

    @Before
    public void init() throws Exception {
        executeSqlFile("sql/customer_init.sql");
        System.out.println("=====begin====init====");
    }

    @Test
    public void getCustomerListTest() throws Exception {
        log.info("=====begin====Test====");
        System.out.println("=====begin====Test====");
        List<Customer> customerList = customerService.getCustomerList();
        for (Customer customer :
                customerList) {
            System.out.println("=====customerList====name====" + customer.getName());
        }

        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        System.out.println("=====customerList====name====" + customer.getName());
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer3");
        fieldMap.put("contact", "heitao");
        fieldMap.put("telephone", "13516666666");
        boolean result = customerService.createCustomer(fieldMap);
        System.out.println("=====customerList====name====" + result);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception {
        long id = 2;
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("email", "aimin@qq");
        boolean result = customerService.updateCustomer(id, fieldMap);
        System.out.println("=====customerList====name====" + result);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception {
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        System.out.println("=====customerList====name====" + result);
        Assert.assertTrue(result);
    }

}
