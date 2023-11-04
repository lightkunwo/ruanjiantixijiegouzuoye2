package bs.servlet;

import bs.Dao.JDBC;
import bs.pojo.lianxiren;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/listServlet")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<lianxiren> pb = null;
        try {
            pb = JDBC.query();
            req.setAttribute("pb",pb);
            req.getRequestDispatcher("/list.jsp").forward(req,resp);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }
}
