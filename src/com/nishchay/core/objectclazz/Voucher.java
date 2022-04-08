package com.nishchay.core.objectclazz;

/*
* TODO - Children should not examine the private members of their parents
*  https://stackoverflow.com/questions/2066917/overriding-equals-hashcode-in-sub-classes-considering-super-fields
*
*
* */
class Voucher extends Money {

    private String store;

    public Voucher(String store) {
        this.store = store;
    }

    public Voucher(int amount, String currencyCode, String store) {
        super(amount, currencyCode);
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (this.getClass() != o.getClass())
            return false;
        if (!(o instanceof Voucher))
            return false;

        Voucher other = (Voucher)o;
        boolean currencyCodeEquals = (this.currencyCode == null && other.currencyCode == null)
          || (this.currencyCode != null && this.currencyCode.equals(other.currencyCode));
        boolean storeEquals = (this.store == null && other.store == null)
          || (this.store != null && this.store.equals(other.store));
        return this.amount == other.amount && currencyCodeEquals && storeEquals;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (store != null ? store.hashCode() : 0);
        return result;
    }

    // other methods
}