package com.liumulin.pay.controller;

import cn.hutool.core.lang.Snowflake;
import com.github.binarywang.wxpay.bean.result.WxPayUnifiedOrderV3Result;
import com.liumulin.pay.service.IPayService;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * pay
 *
 * @author Daniel Liu
 * @date 2022-07-30
 */
@Controller
@RequestMapping("/pay")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PayController {

    public final IPayService payService;

    @GetMapping("/native")
    public ModelAndView nativePay() {
        WxPayUnifiedOrderV3Result wxPayUnifiedOrderV3Result = payService.nativePay(new Snowflake().nextIdStr(), new BigDecimal("1"));
        Map<String, String> map = new HashMap<>();
        map.put("codeUrl", wxPayUnifiedOrderV3Result.getCodeUrl());
        return new ModelAndView("wxNativePay", map);
    }

    @PostMapping("/notify")
    @ResponseBody
    public String asyncNotify(String notifyData) {
        return payService.asyncNotify(notifyData);
    }
}
