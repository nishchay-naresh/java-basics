package com.nishchay.java8.dp;

public class MailerUtil {

    public static void main(String[] args) {

        legacyWay();
        System.out.println("====================================");
        composeWay();
    }

    // so much noisy and fluffy
    private static void legacyWay() {
        MailerLegacy mailer = new MailerLegacy();
        mailer.from("builder@developer.com");
        mailer.to("nishchay@gmail.com");
        mailer.subject("Design Patterns in java 8");
        mailer.body("----------details-----------");
        mailer.send();
    }

    // compose method pattern
    private static void composeWay() {
        Mailer mailer = new Mailer();
        mailer.from("builder@developer.com")
        .to("nishchay@gmail.com")
        .subject("Design Patterns in java 8")
        .body("----------details-----------")
        .send();

    }

    private static class MailerLegacy {

        public void from(String addr) {
            System.out.println("from");
        }

        public void to(String addr) {
            System.out.println("to");
        }

        public void subject(String line) {
            System.out.println("subject");
        }

        public void body(String textMsg) {
            System.out.println("body");
        }

        public void send() {
            System.out.println(".......sending.......");
        }
    }

    private static class Mailer {

        public Mailer from(String addr) {
            System.out.println("from");
            return this;
        }

        public Mailer to(String addr) {
            System.out.println("to");
            return this;
        }

        public Mailer subject(String line) {
            System.out.println("subject");
            return this;
        }

        public Mailer body(String textMsg) {
            System.out.println("body");
            return this;
        }

        public Mailer send() {
            System.out.println(".......sending.......");
            return this;
        }
    }
}
