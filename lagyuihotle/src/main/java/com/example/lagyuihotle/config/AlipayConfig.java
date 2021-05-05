package com.example.lagyuihotle.config;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author ：dragon2082
 * @date ：Created in 2021/5/2 12:37
 */

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2021000117648295";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDojtNeF/YNE3BkTQEds7NWonhIlm5H6+hvYhNucsrjCWIoMko8rjDDDbn/bC0AgtWcCaxRoxWaN+VRmHaeXsmjb+qVFlnMGi8KfcaGgFBGK2XKGVyvvCRaofxrM2wpKKiLPys2ba/9iUHnF4eSMm8YOwcVXpQCsq/5D7xRrwjlmpmeGaD+5wz4bRzmIsA2CqC6hFHxqN1ApGX2YwF0IKiL2iUna5LOhJ/kxIY8htmB9X5K3KsqQFqLyI3Ypdb0PIadP0pcJ5vSd6r1ov1jDy8YNsCXC8B/eGPL1XXPc4XSo7S3ZLdTE0PmBUO/9cM246fJRT0dwkfMZzydvdT2skT7AgMBAAECggEBANh+bcLAp6xQlmapUQqniaJzKWrZr9yAfyeBs/k0IC/vQlONTZLjzj0nACoKOHKrWdQjJSnyml+w/WhSeMrCDxB5VXZpEjtxfK1VnYUE2rYYHHBh3+kxSt6cwfHCM0S1twG6Uq4euqFaL+HEA89T6Bw0h0mbfEpusmc4AOZB/hRPazx2CFbo/Dg8JHEtdwYsM2TCoEyMFAFSkojJNUTSAMfBOnDGutRI4ZDxnmlap+MdJBW9a7Lp9wLHY5tTb3XqyM/sw/Hd4NZYcCGTVXck6Lu7bsNw/9IBc5MV8g3bvzUAQYALp6vBb2dZxlXwN3x+8dFRto+9fhEcassrPqVfx+ECgYEA/61B76qjh74kQHcxUYT/pyEKEe2wqU3SP8DmDXXkVneaylIUZWn86XzDEzQORIyHpD8vSg0qZBPlKbTK16cnuh0EBLj+emZnOHF+93Op7E3MSY3YXRdDJb6pT+x19qfp6Q3UXhgDsPBcJLF3wg+V0ELGLf8LqbN7M+zV5lnLcXkCgYEA6NoWGePuLT+e1b9sZGEWJYt0TdUStg2hkXQvsgxSEO631sJNa0Ndqzy243dGgE6KR2649ndAZtoMb2Yy4lN1S9Bgpp0JAtt2rW/TZW9SmPMIZKl7WFEiAnC6xDIJQv9TAeYmVTAuGXssaHrhvyN3kwc5ZaLWe6mD6fpR0u7qYRMCgYA/EleMrvSOXOqGeKDS8lM6wFzClXcaHNd74LMfqPB+IB0wQdVEO0QnuR5KU3IdmOkxLGEXDG5jp8DFbBMJ5fNX5yaBn70vJqnZ862Vj5PgdkSp9HLmbAGlgwYzcCqdgUijtESqPZRThsfESX84gS285WwMFrmi0GLZKViO7aHRSQKBgQDcc7Ve97PEdSpM1fmqI1zTWO9YzPT1FXy0+Bo76Hw9+bRlh/nCJrpk54uDWaaOzU0Pih1lgsufVKtXQJvGORuhFnya4avpX5xBYdDzhOzfT6DPpMHZgJ7BTrcUDwdDvfV5o8sA9id/CmWl2UknLE4GDl3iAsQrufbhK5QSLw4JrwKBgGFqLRw+cWKiDFzi3nTIWWtLY1h7XJveSRkZ2YTa2yYBh1AxpTJM6St8MEJxJChcMFIrhCvXxcNyd62TRSixyBa43R7wZvDVfARHWda0itIT34XjLEV1MUdryKEsfegwUHQrJupebLSXYJ1I3ohygd14Xqhw2fsvmEE/s2LWDVDg";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvTVq+J+EmUk2bVN7iRjswLThF507YdkZZROvv898RL9YembaJSCFne8l+jjcU6AdQILwcBztI7X11IK31DRnS08Ljj7x51UCfLDpIT5zPuwXRRGuwDeIVc3FId+2Oaf1DB/Vm11YpJqw+kawrgYW1wKm5r1Sy95cn/Si88ujBEmvgM4rNhKdAbiopKmp2xaf4AUROuU3tl4g9curOartbRIKOKIPZPQRjdPOyK1q5/jZiauPg+yPWWfKOP5ItoGXynByZZ8yOHLEt+OMd8WgIwrHifm+mXdjY+4Q5wY8CqVzs+N7uKodnRk4wVHuDlQ1lRLXpJnL2BAoyarq3CWUowIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，假设这里的公网IP和端口为：49.269.31.237:8081
    public static String notify_url = " http://localhost:8080/pay/synnotify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，假设这里的公网IP和端口为：49.269.31.237:8081
    public static String return_url = "http://localhost:8080/pay/return_notify";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
