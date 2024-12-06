package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    @Mock
    private PaymentService paymentServiceMock;

    @InjectMocks
    private BookingService bookingService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcessPaymentCalledDuringBooking() {
        // Arrange: Define mock behavior
        String bookingId = "B123";
        double amount = 200.0;
        when(paymentServiceMock.processPayment(bookingId, amount)).thenReturn(true);

        boolean result = bookingService.bookService(bookingId, amount);

        assertTrue(result);
        verify(paymentServiceMock, times(1)).processPayment(bookingId, amount);
    }
}
