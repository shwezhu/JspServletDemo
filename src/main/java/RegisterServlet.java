import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            //Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();

            //Determine whether the user name is duplicate.
            PreparedStatement st = con.prepareStatement("select * from user where username=?");
            //注意，这里的参数，是input标签的name属性的值，而不是id，不然request.getParameter总是返回null哦
            st.setString(1, request.getParameter("username"));
            ResultSet rs = st.executeQuery();
            //If next() return false it means ResultSet is empty, or vice versa.
            if (rs.next()) {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('username is not available!');");
                out.println("location='/register.jsp';");
                out.println("</script>");
                return;
            }

            st.clearParameters();
            st = con.prepareStatement("insert into user (username, password) values(?, ?)");
            st.setString(1, request.getParameter("username"));
            //Same for second parameter
            st.setString(2, request.getParameter("password"));
            //Execute the insert command using executeUpdate() to make changes in database
            st.executeUpdate();
            //Close all the connections
            st.close();
            con.close();
            //Get a writer pointer to display the successful result
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Register successfully, please sign in!');");
            out.println("location='/login.jsp';");
            out.println("</script>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}