package com.romeulima.tax.domain.Company;

import com.romeulima.tax.domain.taxpayer.TaxPayer;

public class Company extends TaxPayer {

    private Integer numberOfEmployees;


    public Company(){
    }

    public Company(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double tax() {
        Double tax;

        if(this.numberOfEmployees > 10){
            tax = 0.14;
        } else{
            tax = 0.16;
        }

        return getAnualIncome() * tax;
    }
}
