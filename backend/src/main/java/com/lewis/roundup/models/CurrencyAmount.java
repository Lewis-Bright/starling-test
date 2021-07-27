package com.lewis.roundup.models;

public class CurrencyAmount {

   private final String currency;

   private final int minorUnits;

   public CurrencyAmount(String currency, int minorUnits) {
      this.currency = currency;
      this.minorUnits = minorUnits;
   }

   public String getCurrency() {
      return currency;
   }

   public int getMinorUnits() {
      return minorUnits;
   }

   @Override
   public String toString() {
      return "CurrencyAmount{" +
              "currency='" + currency + '\'' +
              ", minorUnits=" + minorUnits +
              '}';
   }
}
