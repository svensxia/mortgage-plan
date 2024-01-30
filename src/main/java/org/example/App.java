package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    static String filepath = "prospects.txt";
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> person1 = new ArrayList<>();
    static ArrayList<String> person2 = new ArrayList<>();
    static ArrayList<String> person3 = new ArrayList<>();
    static ArrayList<String> person4 = new ArrayList<>();


    public static void main( String[] args )
    {
        // Läs in filen
        try{
            File prospects = new File(filepath);
            Scanner scanner = new Scanner(prospects);

            //Skip header
            if(scanner.hasNextLine()){
                scanner.nextLine();
            }

            while (scanner.hasNextLine()){
                String data = scanner.nextLine();
                list.add(data); //add data to arraylist
            }
            scanner.close();

        } catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Ändra listan till array
        person1.add(list.get(0));
        String[] person1Arr = person1.get(0).split(",");

        person2.add(list.get(1));
        String[] person2Arr = person2.get(0).split(",");

        person3.add(list.get(2));
        String[] person3Arr = person3.get(0).split(",");

        person4.add(list.get(3));
        String[] person4Arr = person4.get(0).split(",");

        //Print out the data

        double mortgage1 = mortgageCalc(Double.parseDouble(person1Arr[1]), Double.parseDouble(person1Arr[2]), Integer.parseInt(person1Arr[3]));
        System.out.printf(
                "**********************************************************************************\n" +
                        "Prospect 1: %s wants to borrow %d€ for a period of %d years and pay %.2f€ each month",
                person1Arr[0], Integer.parseInt(person1Arr[1]), Integer.parseInt(person1Arr[3]), mortgage1
        );

        double mortgage2 = mortgageCalc(Double.parseDouble(person2Arr[1]), Double.parseDouble(person2Arr[2]), Integer.parseInt(person2Arr[3]));
        System.out.printf(
                "\n**********************************************************************************\n" +
                        "Prospect 2: %s wants to borrow %d€ for a period of %d years and pay %.2f€ each month",
                person2Arr[0], Integer.parseInt(person2Arr[1]), Integer.parseInt(person2Arr[3]), mortgage2
        );

        double mortgage3 = mortgageCalc(Double.parseDouble(person3Arr[1]), Double.parseDouble(person3Arr[2]), Integer.parseInt(person3Arr[3]));
        System.out.printf(
                "\n**********************************************************************************\n" +
                        "Prospect 3: %s wants to borrow %.2f€ for a period of %d years and pay %.2f€ each month",
                person3Arr[0], Double.parseDouble(person3Arr[1]), Integer.parseInt(person3Arr[3]), mortgage3
        );

        double mortgage4 = mortgageCalc(Double.parseDouble(person4Arr[2]), Double.parseDouble(person4Arr[3]), Integer.parseInt(person4Arr[4]));
        String name = person4Arr[0].replace("\"", "") + " " + person4Arr[1].replace("\"", "");
        System.out.printf(
                "\n**********************************************************************************\n" +
                        "Prospect 4: %s wants to borrow %d€ for a period of %d years and pay %.2f€ each month" +
                        "\n**********************************************************************************\n",
                name, Integer.parseInt(person4Arr[2]), Integer.parseInt(person4Arr[4]), mortgage4
        );
    }

    public static double mortgageCalc(double totalLoan, double interest, int loanTime){
        double monthlyInterest = (interest / 12)/100;
        int numPayments = loanTime * 12;

        double totalPerMonth = totalLoan * (monthlyInterest * pow(1+ monthlyInterest, numPayments)) / (pow(1 + monthlyInterest, numPayments) -1);

        return round(totalPerMonth);
    }

    public static double pow(double number, int power){
        double result = 1.0;
        for (int i = 0; i < power; i++) {
            result *= number;
        }
        return result;
    }

    public static double round(double num){
        double shiftedNum = num * 100.0;
        int integer = (int) shiftedNum;
        double fractional = shiftedNum - integer;

        if ((fractional * 10) % 10 >= 5) {
            integer++;
        }

        return integer / 100.0;
    }
}
