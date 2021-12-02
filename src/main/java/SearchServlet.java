import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            // write these on the top. 否则出现乱码
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            // Initialize the database
            Connection con = DatabaseConnection.initializeDatabase();
            // Determine whether the user name is duplicate.
            PreparedStatement st = con.prepareStatement("select * from student");
            ResultSet rs = st.executeQuery();

            response.setCharacterEncoding("UTF-8");

            PrintWriter out = response.getWriter();
            out.println("<table border=1");    //打印出表格
            out.print("<tr><td width=\"100\">Student ID</td><td width=\"100\">Class</td><td width=\"100\">Name</td><td width=\"100\">Gender</td><td width=\"100\">Age</td><td width=\"100\">Parents Name</td><td width=\"100\">Phone</td></tr>");
            // If next() return false it means ResultSet is empty, or vice versa.
            while(rs.next()){
                out.print("<tr>");
                out.println("<td width=\"100\">"+ rs.getInt(1) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(2) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(3) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(4) + "</td>");
                out.println("<td width=\"100\">"+ rs.getInt(5) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(6) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(7) + "</td>");
                out.println("<td width=\"100\">"+ rs.getString(8) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}