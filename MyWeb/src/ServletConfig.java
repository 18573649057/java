import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletConfig extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        javax.servlet.ServletConfig servletConfig = this.getServletConfig();

//        根据key获取value
        String initParameter = servletConfig.getInitParameter("encoding");
        System.out.println(initParameter);

        //获取servlet的名称
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);

//获取所有的key
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            String name = servletConfig.getInitParameter(s);
            System.out.println(s+"," +name);

        }

        //获取context对象
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext);

        //设置共享的数据

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
