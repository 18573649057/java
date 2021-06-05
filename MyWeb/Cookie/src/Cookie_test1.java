import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Cookie-test1")
public class Cookie_test1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = resp.getWriter();
        pw.write("欢迎访问本网站，访问的时间为：<br/>");
        Cookie cookie = new Cookie("time", System.currentTimeMillis() + "");
        resp.addCookie(cookie);
        cookie.setMaxAge(3600);
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            if ("time".equals(c.getName())) {
                String value = c.getValue();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String s = sdf.format(new Date(Long.parseLong(value)));
                pw.write(s);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
