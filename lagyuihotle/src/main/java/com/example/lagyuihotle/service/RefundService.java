package com.example.lagyuihotle.service;

import com.alipay.api.AlipayApiException;

/**
 * @author ：dragon2082
 * @date ：Created in 2021/5/5 16:52
 */
public interface RefundService {
    Object refund(String ordernumber) throws AlipayApiException;
}
