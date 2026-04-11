package com.example.studentexamproject.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import com.google.zxing.client.j2se.MatrixToImageWriter;

@Service
public class QrCodeService {


    public String generateQr(String data) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 300, 300);

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

            byte[] qrBytes = outputStream.toByteArray();
            String base64 = Base64.getEncoder().encodeToString(qrBytes);

            return "data:image/png;base64," + base64;

        } catch (Exception e) {
            throw new RuntimeException("QR kod yaradılarkən xəta baş verdi");
        }
    }
}

