import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*request.getParameter()获取参数的几种方式
1.html中form表单中标签的name属性
2.html中form表单提交时的action的参数
3.html中url的内容
4.ajax中的data*/
public class SearchStudentServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = null;
        try {
            //注意，这里的参数，是input标签的name属性的值，而不是id，不然request.getParameter总是返回null哦
            //name当时用JQuery的时候，是json的对应名字post的data部分
            student = FetchStudentInfo.searchStudent(Integer.parseInt(request.getParameter("studentID")));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.getWriter().print(gson.toJson(student));
    }
}