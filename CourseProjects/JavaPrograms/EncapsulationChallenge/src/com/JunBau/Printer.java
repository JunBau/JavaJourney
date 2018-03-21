package com.JunBau;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted = 0;
    private boolean duplexPrinter;

    public Printer(int tonerLevel, boolean duplexPrinter) {
        if(tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.duplexPrinter = duplexPrinter;
        this.pagesPrinted = 0;
    }

    public void addToner(int tonerTop) {

        if((this.tonerLevel + tonerTop) <= 100 && (this.tonerLevel + tonerTop) > 0) {
            this.tonerLevel = this.tonerLevel + tonerTop;
            System.out.println("Added: " + tonerTop + ". New level is: " + tonerLevel + "%");
        } else if ((this.tonerLevel + tonerLevel) > 100) {
            System.out.println("Toner level is at 100%, risk of overfilling.");
            this.tonerLevel = 100;
            System.out.println("New level is: " + tonerLevel + "%" );
        } else {
            System.out.println("Invalid action.");
        }

    }

    public void printPage(int addPage) {

        if(tonerLevel >=10 && (5 * pagesPrinted) <= tonerLevel) {
            if (duplexPrinter)
            {
                System.out.println("Printing on both sides.");
            }
            pagesPrinted += addPage;
            this.tonerLevel -= (5 * pagesPrinted);
            System.out.println("Printing " + pagesPrinted + " pages.");
            System.out.println("Toner level: " + tonerLevel);
            pagesPrinted = 0;
        } else {
            System.out.println("Not enough toner available. Currently at: " + tonerLevel + "%");
        }

    }

    public int getTonerLevel() {
        return tonerLevel;
    }
}
