package com.liumulin.pay.service;

import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderV3Request;
import com.github.binarywang.wxpay.bean.request.WxPayUnifiedOrderV3Request.Amount;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderV3Result;
import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import com.google.gson.Gson;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Daniel Liu
 * @date 2022-07-30
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PayServiceImpl implements IPayService {

    private final WxPayService wxPayService;

    @Override
    public WxPayUnifiedOrderV3Result nativePay(String orderId, BigDecimal amount) {
        WxPayConfig config = wxPayService.getConfig();
        WxPayUnifiedOrderV3Request wxPayUnifiedOrderV3Request = new WxPayUnifiedOrderV3Request();
        wxPayUnifiedOrderV3Request.setAppid(config.getAppId());
        wxPayUnifiedOrderV3Request.setMchid(config.getMchId());
        wxPayUnifiedOrderV3Request.setDescription("nice fucked!");
        wxPayUnifiedOrderV3Request.setOutTradeNo(orderId);
        wxPayUnifiedOrderV3Request.setAttach("attach json body");
        wxPayUnifiedOrderV3Request.setNotifyUrl("https://liumulin.com");
        Amount amount1 = new Amount();
        amount1.setTotal(amount.intValue());
        amount1.setCurrency("CNY");
        wxPayUnifiedOrderV3Request.setAmount(amount1);

        String requestStr = new Gson().toJson(wxPayUnifiedOrderV3Request);
        try {
            String resultJsonBody = wxPayService.postV3("https://api.mch.weixin.qq.com/v3/pay/transactions/native", requestStr);
            return new Gson().fromJson(resultJsonBody, WxPayUnifiedOrderV3Result.class);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
    }
}
