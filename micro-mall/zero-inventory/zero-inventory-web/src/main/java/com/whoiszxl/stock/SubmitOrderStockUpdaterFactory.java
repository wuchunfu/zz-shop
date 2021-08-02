package com.whoiszxl.stock;

import com.whoisxl.dto.OrderCreateInfoDTO;
import com.whoisxl.dto.OrderDTO;
import com.whoisxl.dto.OrderItemDTO;
import com.whoiszxl.entity.ProductStock;
import com.whoiszxl.service.ProductStockService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 提交订单库存更新工厂
 *
 * @author whoiszxl
 * @date 2021/8/2
 */
@Component
public class SubmitOrderStockUpdaterFactory<T> extends AbstractStockUpdaterFactory<T> {

    @Autowired
    public SubmitOrderStockUpdaterFactory(ProductStockService productStockService) {
        super(productStockService);
    }

    @Override
    protected List<Long> getProductSkuIds(T parameter) {
        OrderCreateInfoDTO orderCreateInfoDTO = (OrderCreateInfoDTO) parameter;
        List<Long> productSkuIds = new ArrayList<>();

        for (OrderItemDTO item : orderCreateInfoDTO.getOrderItemList()) {
            productSkuIds.add(item.getSkuId());
        }
        return productSkuIds;
    }

    @Override
    protected StockUpdater create(List<ProductStock> productStocks, T parameter) {
        OrderCreateInfoDTO orderCreateInfoDTO = (OrderCreateInfoDTO) parameter;
        Map<Long, OrderItemDTO> orderItemDTOMap = new HashMap<>();
        for (OrderItemDTO item : orderCreateInfoDTO.getOrderItemList()) {
            orderItemDTOMap.put(item.getSkuId(), item);
        }

        return new SubmitOrderStockUpdater(productStocks, productStockService, orderItemDTOMap);
    }
}
