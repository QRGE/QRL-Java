package org.qrl.exception;

/**
 * @author qr
 * @date 2021/11/18 11:22 PM
 */
public class QRException extends RuntimeException{

    public QRException(String message) {
        super(message);
        System.out.println(message);
    }
}
