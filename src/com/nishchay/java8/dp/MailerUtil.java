package com.nishchay.java8.dp;

import java.util.function.Consumer;

/*
* Creating fluent interfaces
*
* */
public class MailerUtil {

    public static void main(String[] args) {

        legacyWay();
        System.out.println("====================================");
        composeWay();
        System.out.println("====================================");
        supplierWay();
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

    // compose method pattern / builder pattern / cascade through pattern
    // - taking the result of one method using it as argument to next method
    private static void composeWay() {
        Mailer mailer = new Mailer();
        mailer.from("builder@developer.com")
        .to("nishchay@gmail.com")
        .subject("Design Patterns in java 8")
        .body("----------details-----------")
        .send();

    }

    // supplier way
    // send - takes a mailer do what even operation its want to do over it
    // should  re-use the Mailer or not -> i no longer have to worry about it , class designer will take care of it
    private static void supplierWay() {
        Mailer.send(mailer ->
        mailer.from("builder@developer.com")
                .to("nishchay@gmail.com")
                .subject("Design Patterns in java 8")
                .body("----------details-----------")
        );

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

        public static void send(Consumer<Mailer> block) {
            Mailer mailer = new Mailer();

            block.accept(mailer);
            System.out.println(".......sending.......");
        }
    }
}
