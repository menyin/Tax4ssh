package console;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestJson {
    @Test
    public void test(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "请求成功");
        List<String> list = new ArrayList<String>();
        list.add("陈百强");
        list.add("张学友");
        list.add("黄家驹");
        list.add("林子祥");
        jsonObject.accumulate("data", list);
        System.out.println(jsonObject.toString());
    }
}
