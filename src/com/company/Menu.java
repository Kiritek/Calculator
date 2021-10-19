package com.company;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void CalculatorInitialisation(){
        Calculator calculator = new Calculator();
        String text;
        String[] splitText;
        double a = 0;
        double b = 0;
        double result = 0;
        char operator = 0;
        StatusOfOperation status = StatusOfOperation.Failure;
        StatusOfConversion conversion = StatusOfConversion.Failure;
        do {
            text = ReadData();
            if (text.charAt(0) != '#'){
                splitText = text.split(" ");
                try {
                    a = Double.parseDouble(splitText[0]);
                    operator = splitText[1].charAt(0);
                    b = Double.parseDouble(splitText[2]);
                    conversion=StatusOfConversion.Success;
                }
                catch(Exception e){
                }
            }
            else operator='#';

            if (conversion==StatusOfConversion.Success){
                status=StatusOfOperation.Success;
            switch(operator){
                case '+'->result=calculator.DoAddition(a,b);
                case '-'->result=calculator.DoSubtraction(a,b);
                case '*'->result=calculator.DoMultiplication(a,b);
                case '/'->{
                    if(b==0){
                        status = StatusOfOperation.FailureDivisionByZero;
                    }
                    else {
                        result = calculator.DoDivision(a, b);
                    }
                }
                case '^'->result=calculator.DoExponentiation(a,b);
                case '#'->status=StatusOfOperation.ExitWithoutOperation;
                default -> status=StatusOfOperation.Failure;
            }
            }
            switch (status){
                case Success -> System.out.println("Result of operation "+a+" "+operator+" "+b+" is "+result);
                case ExitWithoutOperation -> {}
                case FailureDivisionByZero -> System.out.println("You can`t divide by zero");
                case Failure -> System.out.println("You have entered wrong data");
            }
        }while(operator!='#');

    }
    private void PrintMenu(){
        System.out.println("Welcome to simple calculator");
        System.out.println("To start write number then operation symbol then second number. Use space as separator");
        System.out.println("Supported operations :");
        System.out.println("+ addition");
        System.out.println("- subtraction");
        System.out.println("/ division");
        System.out.println("* multiplication");
        System.out.println("^ exponentiation");
        System.out.println("# exit program");
    }
    private String ReadData(){
        PrintMenu();
        return scanner.nextLine();
    }


}
