package servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class InfoServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("properties", readGitProperties());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/info/info.jsp");
        requestDispatcher.forward(request, response);

    }

    private ArrayList readGitProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("git.properties");
        try {
            return readFromInputStream(inputStream);
        } catch (IOException e) {
            return new ArrayList();
        }
    }

    private ArrayList readFromInputStream(InputStream inputStream) throws IOException {
        ArrayList<String> resultString = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null)
                resultString.add(line);
        }
        return resultString;
    }

}