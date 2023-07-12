import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class signin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = md5Hash.encrypted(request.getParameter("password"));

        if(email == null || password == null){
            ApiError.sendRequestDispatch(request, response, 403, "Please enter all fields");
            return;
        }

        PrintWriter out = response.getWriter();
        Connection conn = dbconn.getConnection();
        ResultSet res = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM registerinfo WHERE email = ? and password = ?");

            stmt.setString(1, email);
            stmt.setString(2, password);

            // Execute the query
            ResultSet rs = stmt.executeQuery();

            // Check if the user already exists
            if (rs.next()) {

                Cookie c1 = new Cookie("user", email);
                Cookie c2 = new Cookie("pass", password);
                c1.setMaxAge(60*60*12*30);
                c2.setMaxAge(60*60*12*30);                          //max age 
                HttpSession session = request.getSession(true);
                session.setAttribute("user", email);
                session.setAttribute("fname", rs.getString("fname"));
                session.setAttribute("lname", rs.getString("lname"));
                session.setAttribute("password", password);
                session.setAttribute("type", rs.getString("usertype"));
                session.setMaxInactiveInterval(12 * 60 * 60);        // 12 hours
                response.setStatus(200);

                //adding cookies
                response.addCookie(c1);
                response.addCookie(c2);

                if (rs.getString("usertype").equals("0") ) {
                    // session.setAttribute("name", "Admin");
                    response.sendRedirect("dashboard.jsp");
                } else {
                    // session.setAttribute("name", "Student");
                    response.sendRedirect("dashboard.jsp");
                }

            } else {
                ApiError.sendRequestDispatch(request, response, 404, "Incorrect " + email +" && "+ password);
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ApiError.sendRequestDispatch(request, response, 500, "Server Error Occured");
        }
        out.close();
    }
}
