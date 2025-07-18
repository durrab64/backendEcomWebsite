package com.ecomweb.demo.service.interf;

import com.ecomweb.demo.dto.OrderRequest;
import com.ecomweb.demo.dto.Response;
import com.ecomweb.demo.enums.OrderStatus;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface OrderItemService {

    Response placeOrder(OrderRequest orderRequest);

    Response updateOrderItemStatus(Long orderItemId, String status);

    Response filterOrderItems(OrderStatus status, LocalDateTime startDate , LocalDateTime endDate, Long itemId, Pageable pageable);

}
