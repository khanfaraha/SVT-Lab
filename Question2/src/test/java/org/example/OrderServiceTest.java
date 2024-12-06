package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Test
    void testPlaceOrderValid() {
        ShippingService mockShippingService = Mockito.mock(ShippingService.class);
        OrderService orderService = new OrderService(mockShippingService);

        when(mockShippingService.ship("item1", 5)).thenReturn(true);

        assertTrue(orderService.placeOrder("item1", 5));
        verify(mockShippingService).ship("item1", 5);
    }

    @Test
    void testPlaceOrderInvalidQuantity() {
        ShippingService mockShippingService = Mockito.mock(ShippingService.class);
        OrderService orderService = new OrderService(mockShippingService);

        assertFalse(orderService.placeOrder("item1", 0));
        assertFalse(orderService.placeOrder("item1", -1));

        verify(mockShippingService, never()).ship(anyString(), anyInt());
    }

    @Test
    void testPlaceOrderInvalidItem() {
        ShippingService mockShippingService = Mockito.mock(ShippingService.class);
        OrderService orderService = new OrderService(mockShippingService);

        when(mockShippingService.ship("invalidItem", 5)).thenReturn(false);

        assertFalse(orderService.placeOrder("invalidItem", 5));
        verify(mockShippingService).ship("invalidItem", 5);
    }
}
