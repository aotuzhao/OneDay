package zzu.zhaoxuezhao.com.oneday.entity.news;

/**
 * Created by aotu on 2018/3/14.
 * reason 返回描述
 * result 返回结果
 * error_code 错误码
 */

public class NewsData {
    private String reason;
    private NewResultBridge result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public NewResultBridge getResult() {
        return result;
    }

    public void setResult(NewResultBridge result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
}
