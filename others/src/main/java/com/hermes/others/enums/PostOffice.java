package com.hermes.others.enums;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author liu.zongbin
 * @since 2022/11/28
 */
class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}

    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}

    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}

    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}

    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    @Override
    public String toString() {
        return "Mail " + id;
    }

    public String details() {
        return this + ", generalDelivery=" + generalDelivery +
                ", scannability=" + scannability +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = Enums.random(GeneralDelivery.class);
        m.scannability = Enums.random(Scannability.class);
        m.readability = Enums.random(Readability.class);
        m.address = Enums.random(Address.class);
        m.returnAddress = Enums.random(ReturnAddress.class);
        return m;
    }

    public static Iterable<Mail> generator(final int count) {
        return () -> new Iterator<>() {
            int n = count;

            @Override
            public boolean hasNext() {
                return n-- > 0;
            }

            @Override
            public Mail next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return randomMail();
            }
        };
    }
}

/**
 * 使用枚举实现责任链模式+策略模式
 */
public class PostOffice {

    enum MailHandler {
        GENERAL_DELIVERY {
            @Override
            boolean handle(Mail m) {
                if (m.generalDelivery == Mail.GeneralDelivery.YES) {
                    System.out.println("Using general delivery for " + m);
                    return true;
                }
                return false;
            }
        },

        MACHINE_SCAN {
            @Override
            boolean handle(Mail m) {
                if (m.scannability == Mail.Scannability.UNSCANNABLE) {
                    return false;
                }
                if (m.address == Mail.Address.INCORRECT) {
                    return false;
                }
                System.out.println("Delivering " + m + " automatically");
                return true;
            }
        },

        VISUAL_INSPECTION {
            @Override
            boolean handle(Mail m) {
                if (m.readability == Mail.Readability.ILLEGIBLE) {
                    return false;
                }
                if (m.address == Mail.Address.INCORRECT) {
                    return false;
                }
                System.out.println("Delivering " + m + " normally");
                return true;
            }
        },

        RETURN_TO_SENDER {
            @Override
            boolean handle(Mail m) {
                if (m.returnAddress == Mail.ReturnAddress.MISSING) {
                    return false;
                }
                System.out.println("Returning " + m + " to sender");
                return true;
            }
        };

        abstract boolean handle(Mail m);
    }

    static void handle(Mail mail) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(mail)) {
                return;
            }
        }
        System.out.println(mail + " is a dead letter");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.generator(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}
