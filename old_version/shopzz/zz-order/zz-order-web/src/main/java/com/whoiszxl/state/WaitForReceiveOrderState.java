package com.whoiszxl.state;

import com.whoiszxl.constants.OrderStatusConstants;
import com.whoiszxl.dto.OrderInfoDTO;
import com.whoiszxl.entity.Order;
import com.whoiszxl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 待收货状态
 * @author whoiszxl
 *
 */
@Component
public class WaitForReceiveOrderState extends AbstractOrderState {

	@Autowired
	public WaitForReceiveOrderState(OrderService orderService) {
		super(orderService);
	}

	@Override
	protected Integer getOrderStatus(Order order) {
		return OrderStatusConstants.WAIT_FOR_RECEIVE;
	}
	
	@Override
	public Boolean canConfirmReceipt(Order order) {
		return true;
	}

}
