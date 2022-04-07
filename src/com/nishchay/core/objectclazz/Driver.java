package com.nishchay.core.objectclazz;

/*
 * Violating equals() Symmetry With Inheritance
 *
 * https://www.baeldung.com/java-equals-hashcode-contracts
 *
 *	if (Fruit.class == obj.getClass()) { // Noncompliant; broken for child classes
 *      return ripe.equals(((Fruit)obj).getRipe());
 *    }
 *    if (obj instanceof Fruit ) {  // Noncompliant; broken for child classes
 *      return ripe.equals(((Fruit)obj).getRipe());
 *    }
 *    else if (obj instanceof Season) { // Noncompliant; symmetry broken for Season class
 *      // ...
 *    }
 *
 * ==============Fix=================
 *
 *  if (this.getClass() != o.getClass())
 *      return false;
 *
 * https://rules.sonarsource.com/java/RSPEC-2162
 * */
public class Driver {

    public static void main(String[] args) {

        // money object comparision - works fine
        // moneyComparision();

        // money & voucher object comparision - not working fine
        moneyVoucherComparision();


    }

    private static void moneyVoucherComparision() {
        Money money = new Money(42, "USD");
        Voucher voucher = new Voucher(42, "USD", "Amazon");

        // voucher vs voucher - works fine
        boolean result = voucher.equals(money);  // false,  As expected.
        System.out.println("result = " + result);

        // money vs voucher - not working fine
        result = money.equals(voucher);  // true, That's wrong.
        System.out.println("result = " + result);
    }

    private static void moneyComparision() {
        Money income = new Money(55, "USD");
        Money expenses = new Money(55, "USD");
        boolean balanced = income.equals(expenses);
        System.out.println("balanced = " + balanced);
    }


}
