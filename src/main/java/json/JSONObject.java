package json;

public class JSONObject {
    private String expression;
    private String message;
    private String result;

    public JSONObject()
    {

    }

    public JSONObject(String expression)
    {
        this.expression = expression;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
