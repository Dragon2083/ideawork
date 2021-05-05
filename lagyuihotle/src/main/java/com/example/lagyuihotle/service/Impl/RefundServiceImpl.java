package com.example.lagyuihotle.service.Impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.example.lagyuihotle.config.AlipayConfig;
import com.example.lagyuihotle.service.RefundService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/5/5 21:37
 */
@Service
public class RefundServiceImpl implements RefundService {
    @Override
    public Object refund(String ordernumber) throws AlipayApiException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.gatewayUrl,
                AlipayConfig.app_id,
                AlipayConfig.merchant_private_key,
                "json",
                AlipayConfig.charset,
                AlipayConfig.alipay_public_key,
                AlipayConfig.sign_type
        );
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String out_trade_no = new String(ordernumber);
        //付款金额，从前台获取，必填
        String refund_amount = new String("1200");
        //标识一次退款请求，同一笔交易多次退款需要保证唯一。如需部分退款，则此参数必传；不传该参数则代表全额退款
        String out_request_no = new String(UUID.randomUUID().toString());
        //订单名称/标题，可自定义
        String subject = new String("支付宝沙箱测试");
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"refund_amount\":\""+ refund_amount +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");

        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        //输出
        System.out.println("result:"+result);
        //
        System.out.println("退款成功");
        return result;
    }
}
