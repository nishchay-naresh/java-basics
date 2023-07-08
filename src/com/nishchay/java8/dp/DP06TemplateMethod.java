package com.nishchay.java8.dp;


import java.util.function.Consumer;

/*
 *
 * ================ template method design pattern ===================
 *
 *  A common solution when you need to represent the outline of an algorithm
 *  and have the additional flexibility to change certain parts of it
 *
 *  “I’d love to use this algorithm, but I need to change a few lines, so it does what I want.”
 *
 * */
public class DP06TemplateMethod {

    public static void main(String[] args) {

        DP06TemplateMethod ref = new DP06TemplateMethod();
        ref.legacyWay();
        System.out.println("------------------------------------------");
        ref.lambdaWay();
    }


    private void legacyWay() {
        OnlineBanking bank = new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println("bank1 impl - " + c + " happy now");
            }
        };

        bank.processCustomer(10);

        bank = new OnlineBanking() {
            @Override
            void makeCustomerHappy(Customer c) {
                System.out.println("bank2 impl - " + c + " sad now");
            }
        };

        bank.processCustomer(10);
    }


    private void lambdaWay() {
        new OnlineBankingLambda().processCustomer(5, c -> System.out.println("bank1 impl - " + c + " happy now"));
        new OnlineBankingLambda().processCustomer(5, c -> System.out.println("bank2 impl - " + c + " sad now"));
    }


    abstract static class OnlineBanking {
        private Customer getCustomerWithId(int id) {
            return new Customer("c" + id);
        }

        public void processCustomer(int id) {
            Customer c = getCustomerWithId(id);
            makeCustomerHappy(c);
        }

        abstract void makeCustomerHappy(Customer c);

    }


    static class OnlineBankingLambda {
        private Customer getCustomerWithId(int id) {
            return new Customer("c" + id);
        }

        public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
            Customer c = getCustomerWithId(id);
            makeCustomerHappy.accept(c);
        }
    }

    static class Customer {
        String name;

        public Customer(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
