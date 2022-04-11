package com.nishchay.core.objectclazz;

class Money {

    int amount;
    String currencyCode;

    public Money() {
    }

    public Money(int amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("------------executing equals method-------");
        if (o == this)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        if (!(o instanceof Money))
            return false;
        Money other = (Money)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
                || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        return this.amount == other.amount && currencyCodeEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (currencyCode != null) {
            result = 31 * result + currencyCode.hashCode();
        }
        return result;
    }

}