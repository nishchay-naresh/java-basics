package com.nishchay.core.immutable;

import com.nishchay.core.immutable.pojo.Address;
import com.nishchay.core.immutable.pojo.ImmutableAccount;
import com.nishchay.core.immutable.pojo.ImmutableEmp;
import com.nishchay.core.immutable.pojo.Transactions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestImmutability {

    public static void main(String[] args) {

        testImmutableEmp();
        testImmutableAccount();
    }

    private static void testImmutableEmp() {

        Date doj = new Date();
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Delhi", 10006));

        ImmutableEmp emp = new ImmutableEmp(1, "Nishchay", 50000, doj, addressList);

        // 1. Test Constructor Defensive Copy (Date)
        doj.setTime(0);
        System.out.println("Original DOJ modified: " + doj);
        System.out.println("Employee DOJ should NOT change: " + emp.getDoj());

        // 2. Test Getter Defensive Copy (Date)
        Date empDoj = emp.getDoj();
        empDoj.setTime(0);
        System.out.println("Modified returned DOJ: " + empDoj);
        System.out.println("Internal DOJ should remain unchanged: " + emp.getDoj());


        // 3. Try Breaking Address List (Structure)
        // throw - java.lang.UnsupportedOperationException
        // emp.getAddresses().add(new Address("Mumbai", 40008));

        // 4. Try Breaking Internal Address Object
        //emp.getAddresses().get(0).setCity("HackedCity");

        System.out.println(emp.getAddresses().get(0).getCity());
    }

    private static void testImmutableAccount() {

        List<Transactions> txList = new ArrayList<>();
        txList.add(new Transactions("T1", 100));

        Address address = new Address("Delhi", 110001);
        ImmutableAccount account = new ImmutableAccount(123L, txList, address);

        // Modify the original list
        txList.add(new Transactions("T2", 500));

        System.out.println("Original List Modified: " + txList.size());                                     // 2
        System.out.println("Account Transactions Size (should be 1): " + account.getTransactions().size()); // 1
    }

}
