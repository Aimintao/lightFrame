package code.heitao.controller;

import code.heitao.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*使用servlet3.0注解*/
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet{

    public static void main(String[] args) {
        Customer customer= new  Customer();
        customer.setName("aimin");
        System.out.println(customer.getName());

    }
    /*doGet 默认执行*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime=dateFormat.format(new Date());
        System.out.println("当前时间"+currentTime);
        req.setAttribute("currentTime",currentTime);
        req.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(req,resp);
    }
}
