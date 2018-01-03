import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTest {
    public static void main(String[] args) {
        String jsonStr = "{\"code\":1,\"message\": \"查询成功\",\"data\": " +
                "[{\"type\": 1,\"question\": \"题目名称题目名称题目名称题目1111111111111111111111111\"," +
                "\"answer\": \"1\",\"id\":1,\"description\": \"题目描述\",\"answers\": [{\"isCorrect\": 1," +
                "\"answer_name\": \"A的选项内容\"},{\"isCorrect\": 0,\"answer_name\": \"B的选项内容\"}," +
                "{\"isCorrect\": 0,\"answer_name\": \"C的选项内容\"},{\"isCorrect\": 0,\"answer_name\": " +
                "\"D的选项内容\"}]},{\"type\": \"1\",\"question\": \"题目名称题目名称题目名称2222222222222222222222222222\"," +
                "\"answer\": \"2\",\"id\": 1,\"description\": \"题目描述\",\"answers\": [{\"isCorrect\": 1,\"answer_name\": " +
                "\"A的选项内容\"},{\"isCorrect\": 0,\"answer_name\": \"B的选项内容\"},{\"isCorrect\": 0,\"answer_name\": " +
                "\"C的选项内容\"},{\"isCorrect\": 0,\"answer_name\": \"D的选项内容\"}]}]}";
        try {
            JSONObject object = new JSONObject(jsonStr);

            JSONArray jsonArray2 = null;
            JSONObject resObject = null;
            JSONArray jsonArray = (JSONArray) object.opt("data");

            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).opt("answer").equals("1")) {
                    jsonArray2 = (JSONArray) jsonArray.getJSONObject(i).opt("answers");
                    for (int j = 0; j < jsonArray2.length(); j++) {
                        if (jsonArray2.getJSONObject(i).opt("answer_name").equals("A的选项内容")) {
                            resObject = new JSONObject();
                            resObject.put("解析后的字符串", jsonArray2.getJSONObject(i));
                        }
                    }
                }
            }
            System.out.println(resObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
