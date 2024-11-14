package com.pluralsight.model;

import com.pluralsight.model.enums.ChipsType;

public class Chips {
    ChipsType chips;

    public ChipsType getChips() {
        return chips;
    }

    public void setChips(ChipsType chips) {
        this.chips = chips;
    }

    public double getChipsPrice() {
        double total = chips.getPrice();
        return total;
    }
}
