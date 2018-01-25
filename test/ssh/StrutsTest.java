package ssh;

import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

public class StrutsTest {

    public String index(){
        ActionContext context = ActionContext.getContext();
        Map<String, Object> request = context.getContextMap();
        request.put("request_data", "这时测试struts的demo");
        System.out.println("测试struts2");
        return "index";
    }
}
