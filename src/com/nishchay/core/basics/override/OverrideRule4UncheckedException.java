package com.nishchay.core.basics.override;

import java.io.IOException;

public class OverrideRule4UncheckedException {

    public static void main(String[] args) throws IOException {

        Parent p = new Child();
        p.go();
        p.go1();
        p.go2();

        p.fo();
        p.fo1();
        p.fo2();

        p.po();

    }
}
