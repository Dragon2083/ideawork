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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDYl0jdMUwAg8Om0LTpaWvUkVo2V5rFlF4bUf1p3Ao5gZy5iul76Dk17HaxR0DvfazBUS4GmR34yOYhIGY2Q8Zr/LWSZRCpD8tRIK4I4WEsedA1EMLyVwfGW9od0mg0dDbIT3qKv7H9Y76QuBi7LelrRpDOyqLG2vr0cj/DWVfJhqQep0z+CPXhguiaHTI6Pxma0gJiAEaQuiz9dOHqTAgtad2OS9QAslnojIGHaOAyG0cpNzkd4LprK3Q2yL/nE1sF70maxRa3CwmYwi7gJ/I9YirdaRB24vhKeAVQ8J9SvRPn7WGsKI2d2yrHdoDv4UYPH6k/5ZjMDmipvcUopzonAgMBAAECggEAW+NzCkSL1fwQ2YjZ99y93qT7/OoVw5U6h6S1OmAcBmGyuBTzEZpoCzSS9osgRXqv/CQQvsPfL1ksKQmx03vVhqLj9YPjGZaVz4lpzGKx80iKyLifvGin58O4Oca2ZuqXA0yU1KCXRsU2Z/dyppbH3LdHYDQf8vWcWnDOFHanA9vPNbVo0mpheHZYjY2JEWezFtumDGoPzbfWPJdGyalUToWPLFX+IgJWxMjClquYYChxppu9+jk08w6kY2Pe6iGu3PDqunHYoQ8uttdp5+1IcZ21f62qOvFnN9hZ2xYp2NX/yyCAoi0aVO96rVlIYPUmtt+FK716iIHY0pM0D61eAQKBgQD7KFWy2GCuLCa+2lig9j1Ma5W0dc8PrVcCbOiwebINqw6jkGmyvRmPr/U9ipynA3Vx02J83PAvD63i0S5ZvTLBIJOxif+q/MfSNPiKZgp69dFziGwuK8jQbjIw7SirES24WJwaAix/+BO8ePPAO2sQNIYL3V/amefmAKORrT5IwQKBgQDcxFX2JewoTcLVaTybSv9dwKYkrF29K228lq8mWHotQuHlOu956Xiq7J3Ts02ma4TawgW/6yKQ6on8CR9eQ4FHJz9P7ESjM9ZsxgdJqYWUKe9NQEK7P7BAc2yFgbkadQx19L4TYO+sjATKvY0faLoNhpJuxA8FeqB6AHYHaGSU5wKBgEfDgKk3lnht+Swza3uioGVDoGUN/Ho4R1JUGDDEtRGevPITg4Ak9DbQSjypbJV0MYyyn8OZxa9MxZy3tIzDuMriKhFiowESdW4k4Jd7DKeRsaVXZ8HRlPGpawH74dDveabg+smbsWdnVQxXax6UW8UnnN2rBYaKz24y5IntfIyBAoGAHG5Mg76ugyJAjStYWsd1y6UbwG1SRSJqp3bgZ5fNZDbQ0KyeWpzupVSDntfgkCYYnfOOugCWGwOZcZPbLlCTPY6YYLqUvE/YtXlrRtlGEqaz4sb70RGKqUI0H51tMTMRv78dG3HIa/g8Rb/ThM//5e4Gva0SIiqAsDWO/bU7/tECgYBoqNwt4n877NtJf2qWDQxaAnTMciA3V2Z7jZuqZivjdubS9qMj7pNXAp1Q/PAj1TQ9PRHfjGiSyLmyhSeeS66wOPtEGIDb197PnHroBiJubPnvudyZvhVDhMx8paeB/ZhAVVAq2ehzglDyTFL8S3PgZyWsRhr7cawmsWwivLzwHA==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2JdI3TFMAIPDptC06Wlr1JFaNleaxZReG1H9adwKOYGcuYrpe+g5Nex2sUdA732swVEuBpkd+MjmISBmNkPGa/y1kmUQqQ/LUSCuCOFhLHnQNRDC8lcHxlvaHdJoNHQ2yE96ir+x/WO+kLgYuy3pa0aQzsqixtr69HI/w1lXyYakHqdM/gj14YLomh0yOj8ZmtICYgBGkLos/XTh6kwILWndjkvUALJZ6IyBh2jgMhtHKTc5HeC6ayt0Nsi/5xNbBe9JmsUWtwsJmMIu4CfyPWIq3WkQduL4SngFUPCfUr0T5+1hrCiNndsqx3aA7+FGDx+pP+WYzA5oqb3FKKc6JwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，假设这里的公网IP和端口为：49.269.31.237:8081
    public static String notify_url = " http://49.269.31.237:8081 /pay/synnotify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问，假设这里的公网IP和端口为：49.269.31.237:8081
    public static String return_url = "http://49.269.31.237:8081/pay/return_notify";

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
