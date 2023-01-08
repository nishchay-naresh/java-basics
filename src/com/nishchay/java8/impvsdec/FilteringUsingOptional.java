package com.nishchay.java8.impvsdec;

import java.util.Optional;

/*
 *
 * two diff implementation for optional
 *       Imperative way
 *       Declarative way
 *
 * */
public class FilteringUsingOptional {

    public static void main(String[] args) {

        System.out.println("validateSolicitedFlag(\"F\") - " + validateSolicitedFlag("F"));
        System.out.println("validateSolicitedFlag(\"R\") - " + validateSolicitedFlag("R"));
        System.out.println("validateSolicitedFlag(\"Y\") - " + validateSolicitedFlag("Y"));
        System.out.println("validateSolicitedFlag(\"A\") - " + validateSolicitedFlag("A"));
        System.out.println("validateSolicitedFlag(\"Z\") - " + validateSolicitedFlag("Z"));
        System.out.println("validateSolicitedFlag(\"N\") - " + validateSolicitedFlag("N"));

        System.out.println("-------------------------------------");

        System.out.println("validateSolicitedFlagOptionally(\"F\") - " + validateSolicitedFlagOptionally("F"));
        System.out.println("validateSolicitedFlagOptionally(\"R\") - " + validateSolicitedFlagOptionally("R"));
        System.out.println("validateSolicitedFlagOptionally(\"Y\") - " + validateSolicitedFlagOptionally("Y"));
        System.out.println("validateSolicitedFlagOptionally(\"A\") - " + validateSolicitedFlagOptionally("A"));
        System.out.println("validateSolicitedFlagOptionally(\"Z\") - " + validateSolicitedFlagOptionally("Z"));
        System.out.println("validateSolicitedFlagOptionally(\"N\") - " + validateSolicitedFlagOptionally("N"));

    }

    /*
     *
     * */
    private static String validateSolicitedFlag(String flag) {
        if ("F".equals(flag) || "R".equals(flag) || "Y".equals(flag)) {
            return "Y";
        } else if ("N".equals(flag)) {
            return "N";
        }
        return null;
    }

    /*
     *
     * */
    private static String validateSolicitedFlagOptionally(String flag) {
        if (Optional.ofNullable(flag).filter(value -> value.matches("F|R|Y")).isPresent()) {
            return "Y";
        } else if (Optional.ofNullable(flag).filter(value -> value.matches("N")).isPresent()) {
            return "N";
        }
        return null;
    }

}
