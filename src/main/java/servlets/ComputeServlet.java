package servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import valid.Validator;
import parse.Analysis;
import arifmetic.SyntaxAnalisator;

public class ComputeServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException , ServletException{
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/printOutExpr/exprCompute.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String jsonExpr = request.getParameter("expr");
        Validator validator = new Validator();


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create(); //объект для вывода
        JSONObject obj = new JSONObject();


        String answer;
        if (validator.isJSONValid(jsonExpr)) {
            String expr = Analysis.analysis(jsonExpr);//вытаскиваем выражение из json файла
            if (expr!=null) {
                SyntaxAnalisator syntaxAnalisator = new SyntaxAnalisator();
                answer = syntaxAnalisator.getAnalyseStr(expr);
            }
            else {
                obj.setMessage("The request must be in the following format: {\"expression\": \"*expression*\" }\"\n");
                answer = gson.toJson(obj);
            }
        }
        else {
            obj.setMessage("\"message\":\"Request is not a json object\"\n");
            answer = gson.toJson(obj);
        }

        request.setAttribute("json", answer);
        doGet(request, response);
    }


}
