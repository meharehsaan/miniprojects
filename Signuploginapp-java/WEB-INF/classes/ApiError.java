import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.*;

public class ApiError extends Exception {
    int status;
    String message;

    public ApiError(String msg, int status) {
        super(msg);
        this.message = msg;
        this.status = status;
    }

    public ApiError(String msg, int status, HttpServletResponse response) {
        super(msg);
        this.message = msg;
        this.status = status;
        response.setStatus(status);
        return;
    }

    public String getMessage() {
        return this.message;
    }

    public int getStatus() {
        return this.status;
    }

    public void print(HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println(this.message);
        response.setStatus(this.status);
    }

    public static void sendRequestDispatch(HttpServletRequest request, HttpServletResponse response, int status,
            String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        response.setStatus(status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);

        // response.setContentType("text/html");
        // PrintWriter out = response.getWriter();

        // out.println("<html>");
        // out.println("<head>");
        // out.println("<title>Error Occured</title>");
        // out.println("</head>");
        // out.println("<body>");
        // out.println("<h1>Error Occurred</h1>");
        // out.println("<p>" + status + "&nbsp;" + message + "</p>");

        // out.println("</body>");
        // out.println("</html>");
        return;
    }
}
