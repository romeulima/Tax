import com.romeulima.tax.domain.Company.Company;
import com.romeulima.tax.domain.individual.Individual;
import com.romeulima.tax.domain.taxpayer.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char typeOfTaxPayer = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            if(typeOfTaxPayer == 'i'){
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                taxPayerList.add(new Individual(name, anualIncome, healthExpenditures));
            } else{
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = sc.nextInt();
                taxPayerList.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAX PAID");

        for (TaxPayer taxPayer : taxPayerList){
            System.out.println(taxPayer.getName() + ": $ " + String.format("%.2f", taxPayer.tax()));
        }

        Double sum = 0.0;

        for (TaxPayer taxPayer : taxPayerList){
            sum += taxPayer.tax();
        }

        System.out.println();
        System.out.println("Total Taxes: " + sum);
    }
}