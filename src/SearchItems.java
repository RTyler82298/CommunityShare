import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.Map;

@WebServlet(name = "SearchItems", value = "/SearchItems")
public class SearchItems extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String item = request.getParameter("item");
        String search = DBUtils.getItemPosts(item);
        PrintWriter out = response.getWriter();
        out.println(search);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
