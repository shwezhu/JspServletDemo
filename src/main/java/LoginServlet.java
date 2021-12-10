import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginServlet extends HttpServlet {
    // 登录界面应该把login.jsp的表单设置为post提交(不可为get)，然后在这重写doPost方法，不然登录成功后浏览器url栏显示用户名和密码不安全。
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        //注意，这里的参数，是input标签的name属性的值，而不是id，不然request.getParameter总是返回null哦
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            // Determine whether the username is duplicate.
            PreparedStatement st = con.prepareStatement("select * from user where username=?");
            st.setString(1, request.getParameter("username"));
            ResultSet rs = st.executeQuery();

            // If next() return false it means ResultSet is empty, or vice versa.
            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    request.setAttribute("username", username);
                    // forward中能在项目内的页面每个jsp中跳转
                    // 跳转外部链接 用sendRedirect()
                    request.getRequestDispatcher("/home.jsp").forward(request, response);
                } else {
                    PrintWriter out = response.getWriter();
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Incorrect password!');");
                    out.println("location='/login.jsp';");
                    out.println("</script>");
                }
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('User does not exist!');");
                out.println("location='/login.jsp';");
                out.println("</script>");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
