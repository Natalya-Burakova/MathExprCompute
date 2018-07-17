package arifmetic;

public class SyntaxAnalisator {

    public String analyse(String expr) {
        double res = 0;
        String answer;
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
        String analyseStr = analyse(expr);
        if (analyseStr.equals("Syntax error") || analyseStr.equals("Division by zero") || analyseStr.equals("Unbalanced Parentheses") ||  analyseStr.equals("No Expression Present"))
            return "{\n" + "\"expression\":" + "\"" + expr + "\",\n" + "\"message\":"+"\"" + analyseStr + "\""+"\n}";
        else
            return "{\n" + "\"expression\":" + "\"" + expr + "\",\n" + "\"result\":"+ "\"" + analyseStr + "\"" +"\n}";
    }
}
