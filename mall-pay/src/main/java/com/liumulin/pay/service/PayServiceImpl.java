package com.liumulin.pay.service;

import com.github.binarywang.wxpay.bean.notify.WxPayOrderNotifyV3Result;
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
        wxPayUnifiedOrderV3Request.setNotifyUrl("https://liumulin.com"); // TODO 改为花生壳
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

    /**
     * @param notifyData 微信回调内容
     * @return 应答微信，告诉微信不要再通知了
     */
    @Override
    public String asyncNotify(String notifyData) {
        log.info("notifyData = {}", notifyData);
        //1. 签名校验
        try {
            WxPayOrderNotifyV3Result wxPayOrderNotifyV3Result = wxPayService.parseOrderNotifyV3Result(notifyData, null);
            log.info("wxPayOrderNotifyV3Result = {}", wxPayOrderNotifyV3Result);
        } catch (WxPayException e) {
            throw new RuntimeException(e);
        }
        //2. 金额校验（从数据库查订单）
        //3，修改订单支付状态
        //4，告诉微信不要再通知了
        return "{  \n"
                + "    \"code\": \"SUCCESS\",\n"
                + "    \"message\": \"成功\"\n"
                + "}";
    }

}