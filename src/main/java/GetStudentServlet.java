import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetStudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<Student> studentList;
        studentList = FetchStudentInfo.getStudentInfo();

        Gson gson = new Gson();
        JsonElement jsonElement = gson.toJsonTree(studentList, new TypeToken<List<Student>>(){}.getType());
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        //Certain request customizations require setting HTTP headers.
        //application/json: Indicates that the request body format is JSON.
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        //response.getWriter() returns a PrintWriter object that can send character text to the client.
        response.getWriter().print(jsonArray);
        /*print() actually is out.write().
        What is the exact difference between out.write() and out.print()?
        The basic difference is that out.write() explodes if you pass it a null:
        String s = null;
        out.print(s); // outputs the text "null"
        out.write(s); // NullPointerException*/
    }
}