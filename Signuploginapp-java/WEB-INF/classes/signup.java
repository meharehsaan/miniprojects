import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.*;

public class signup extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        PrintWriter out = response.getWriter();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String cpassword = request.getParameter("cpass");
        String str = request.getParameter("code");

        String type;
        if (str.equals("admin")) {
            type = "0";
        } else {
            type = "1";
        }

        String error = null;
        if (fname == null || lname == null || email == null || password == null) {
            ApiError.sendRequestDispatch(request, response, 403, "Please enter all fields");
            return;
        } else {
            if (!password.equals(cpassword)) {
                ApiError.sendRequestDispatch(request, response, 401, "Passwords must be same");
                return;
            } else if (fname.length() < 3 || fname.length() > 10) {
                error = "first name must be between 3 - 10 chars";
            } else if (lname.length() < 3 || lname.length() > 10) {
                error = "last name must be between  3 - 10 chars";
            } else if (password.length() < 6 || password.length() > 15) {
                error = "password must be between 6 - 15 chars";
            } else if (email.length() < 5 || email.length() > 20) {
                error = "enter valid email";
            }

            password = md5Hash.encrypted(password);

            if (error != null) {
                ApiError.sendRequestDispatch(request, response, 401, error);
                return;
            }
        }

        // SQL connection
        Connection conn = dbconn.getConnection();
        int res = 1;
        try {

            // to check if already exists
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM registerinfo WHERE email = ?");
            statement.setString(1, email);
            ResultSet users = statement.executeQuery();

            if (users.next()) {
                ApiError.sendRequestDispatch(request, response, 400, email + " is already present");
            } else {
                // insert record in database
                String query = "INSERT INTO registerinfo (fname, lname, email, password, usertype) VALUES(?, ?, ?, ?, ?);";
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, fname);
                st.setString(2, lname);
                st.setString(3, email);
                st.setString(4, password);
                st.setString(5, type);
                res = st.executeUpdate();

                // you can directly login user after signup instead of redirecting to login page
                if (res > 0) {
                    // Cookie c1 = new Cookie("user", email);
                    // Cookie c2 = new Cookie("pass", password);
                    // c1.setMaxAge(60 * 60 * 12 * 30);
                    // c2.setMaxAge(60 * 60 * 12 * 30); // max age
                    // HttpSession session = request.getSession(true);
                    // session.setAttribute("user", email);
                    // session.setAttribute("fname", fname);
                    // session.setAttribute("password", password);
                    // session.setAttribute("type", type);
                    // session.setMaxInactiveInterval(12 * 60 * 60); // 12 hours
                    // response.setStatus(200);

                    // // adding cookies
                    // response.addCookie(c1);
                    // response.addCookie(c2);

                    // if (type.equals("0")) {
                    // response.sendRedirect("dashboard.jsp");
                    // } else {
                    ApiError.sendRequestDispatch(request, response, 999, "Registered Successfully");
                    // }
                } else {
                    ApiError.sendRequestDispatch(request, response, 500, "User is not saved into database");
                }
                st.close();
            }
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ApiError.sendRequestDispatch(request, response, 500, "Error occured on server" + ex.getMessage());
        }
        out.close();
    }
}
