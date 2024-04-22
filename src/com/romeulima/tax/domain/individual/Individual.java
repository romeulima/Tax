package com.romeulima.tax.domain.individual;

import com.romeulima.tax.domain.taxpayer.TaxPayer;

public class Individual extends TaxPayer {

    private Double healthExpenditures;


    public Individual(){
    }

    public Individual(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double tax() {
        Double tax;
        if (getAnualIncome() < 20000.00){
            tax = 0.15;
        } else {
            tax = 0.25;
        }

        Double total;

        if (getHealthExpenditures() != 0.0){
            total = (getAnualIncome() * tax) - (getHealthExpenditures() * 0.5);
        } else {
            total = (getAnualIncome() * tax);
        }

        return total;
    }
}
