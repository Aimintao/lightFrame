package framework.controller;

import framework.entity.Customer;
import framework.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Aimin
 * @Title: CustomerServlet
 * @ProjectName lightFrame架构
 * @Description: 进入 客户列表 界面
 * @date 2018/6/13 18:49
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerServiceImpl customerServiceImpl;

    @Override
    public void init() throws ServletException {
        customerServiceImpl = new CustomerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerServiceImpl.getCustomerList();
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
