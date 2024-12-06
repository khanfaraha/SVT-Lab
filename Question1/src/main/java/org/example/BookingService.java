package org.example;

public class BookingService {
    private final PaymentService paymentService;

    public BookingService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean bookService(String bookingId, double amount) {
        // Book service and process payment
        return paymentService.processPayment(bookingId, amount);
    }
}
