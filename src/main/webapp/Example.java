package main.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/example")
public class Example extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle form submission
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String grade = request.getParameter("grade");

        // Process form data, store in database, etc.
        // For demonstration purposes, let's just print the received data
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + roll);
        System.out.println("Grade: " + grade);

        // Construct HTML response
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<!DOCTYPE html>");
        htmlResponse.append("<html lang=\"en\">");
        htmlResponse.append("<head>");
        htmlResponse.append("<meta charset=\"UTF-8\">");
        htmlResponse.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        htmlResponse.append("<title>Form Submission Confirmation</title>");
        htmlResponse.append("</head>");
        htmlResponse.append("<body>");
        htmlResponse.append("<h2>Form Submission Confirmation</h2>");
        if (grade.equalsIgnoreCase("A")) {
            htmlResponse.append("<p>Thank you for submitting the form.</p>");
            // Add link to the "result" servlet
            htmlResponse.append("<p><a href=\"result\">View Last Result</a></p>");
        } else {
            htmlResponse.append("<p>Error: You are not smart enough to submit data!</p>");
        }
        htmlResponse.append("<a href='./'>Back to Form</a>");
        htmlResponse.append("</body>");
        htmlResponse.append("</html>");

        // Set content type and write HTML response to the servlet's response stream
        response.setContentType("text/html");
        response.getWriter().write(htmlResponse.toString());
    }
}

