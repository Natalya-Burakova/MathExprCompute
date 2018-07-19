package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import valid.Validator;
import parse.Analysis;
import arifmetic.SyntaxAnalisator;

public class ComputeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/exprCompute.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String jsonExpr = request.getParameter("expr");
        Validator validator = new Validator();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        String answer;
        //если json файл является валидным
        if (validator.isJSONValid(jsonExpr)) {
            String expr = Analysis.analysis(jsonExpr);//вытаскиваем выражение из json файла
            if (expr!=null) {
                SyntaxAnalisator syntaxAnalisator = new SyntaxAnalisator();
                answer = syntaxAnalisator.getAnalyseStr(expr);
            }
            else
                answer = "{\n" + "\"message\":\"The request must be in the following format: {\"expression\": \"*expression*\" }\"\n" + "}\n";
        }
        else {
            answer = "{\n" + "\"message\":\"Request is not a json object\"\n" + "}\n";
        }



        request.setAttribute("json", answer);
        doGet(request, response);
    }


}
