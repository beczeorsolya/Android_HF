package com.example.android7;

public class Prices {
    private final int flags;
    private String currencies;
    private String cur_long;
    private Double sell;
    private Double buy;

    public Prices(int flags, String currencies, String cur_long, Double sell, Double buy) {
        this.flags = flags;
        this.currencies = currencies;
        this.cur_long = cur_long;
        this.sell = sell;
        this.buy = buy;
    }

    public int getFlags() {
        return flags;
    }

    public String getCurrencies() {
        return currencies;
    }

    public Double getSell() {
        return sell;
    }

    public Double getBuy() {
        return buy;
    }

    public String getCur_long() {
        return cur_long;
    }
}
