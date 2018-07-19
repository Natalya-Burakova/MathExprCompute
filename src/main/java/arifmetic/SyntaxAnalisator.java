package arifmetic;

import json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SyntaxAnalisator {

    public String analyse(String expr) {
        double res = 0;
        try {
            res = new Parser().evaluate(expr);
        } catch (ParserException e) {
            return e.toString();
        } catch (Exception e) {
            return e.toString();
        }
        return String.valueOf(res);
    }

    public String getAnalyseStr(String expr) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        JSONObject obj = new JSONObject(expr);
        String analyseStr = analyse(expr);

        if (analyseStr.equals("Syntax error") || analyseStr.equals("Division by zero") || analyseStr.equals("Unbalanced Parentheses") ||  analyseStr.equals("No Expression Present")) {
            obj.setMessage(analyseStr);
            return gson.toJson(obj);
        }
        else {
            obj.setResult(analyseStr);
            return gson.toJson(obj);
        }
    }
}
