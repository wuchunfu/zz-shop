package com.whoiszxl.factory;

import com.whoiszxl.feign.BTCFeignClient;
import com.whoiszxl.feign.CreateAddressFeignClient;
import com.whoiszxl.feign.ETHFeignClient;
import com.whoiszxl.feign.ZXLFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数字货币地址创建工厂
 *
 * @author whoiszxl
 * @date 2021/8/3
 */
@Component
public class CreateDcAddressFactory {

    @Autowired
    private BTCFeignClient btcFeignClient;

    @Autowired
    private ETHFeignClient ethFeignClient;

    @Autowired
    private ZXLFeignClient zxlFeignClient;

    /**
     * 通过数字货币名称获取地址创建客户端
     * @param dcName 数字货币名称
     * @return
     */
    public CreateAddressFeignClient get(String dcName) {
        switch (dcName) {
            case "BTC":
                return btcFeignClient;
            case "ETH":
                return ethFeignClient;
            case "ZXL":
                return zxlFeignClient;
            default:
                return btcFeignClient;
        }
    }
}
