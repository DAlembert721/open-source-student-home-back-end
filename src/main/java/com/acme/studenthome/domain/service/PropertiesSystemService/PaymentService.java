package com.acme.studenthome.domain.service.PropertiesSystemService;

import com.acme.studenthome.domain.model.PropertiesSystem.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    Payment createPayment(Long contractId, Payment payment);
    Payment getPaymentById(Long paymentId);
    Payment updatePayment(Long paymentId, Payment resource);
    ResponseEntity<?> deletePayment(Long paymentId);
    Page<Payment> getAllPaymentsByContractId(Long contractId, Pageable pageable);
}