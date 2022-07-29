package com.liumulin.pay.service;

import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderV3Result;
import java.math.BigDecimal;

/**
 * pay module
 *
 * @author Daniel Liu
 * @date 2022-07-29
 */
public interface IPayService {

    /**
     * 微信扫码支付
     *
     * @param orderId 订单号
     * @param amount  支付金额
     * @return 统一下单返回结果
     */
    WxPayUnifiedOrderV3Result nativePay(String orderId, BigDecimal amount);

}
