package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class InfoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<p>Info or repo: </p>\n" +
                "<body>\n" + readGitProperties() +
                "</body>\n" +
                "</html>");
    }

    private String readGitProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("git.properties");
        try {
            return readFromInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return "Version information could not be retrieved";
        }
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (Exception e){e.printStackTrace();}
        return resultStringBuilder.toString();
    }

}