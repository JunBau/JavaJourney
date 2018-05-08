package com.JunBau;

import java.util.Scanner;

public class Main {

    private static Scanner userInput = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

//
//        // This is how you deal with inner classes.
//        Gearbox McLaren = new Gearbox(6);
//        McLaren.OperateClutch(true);
//        McLaren.ChangeGear(1);
//        McLaren.OperateClutch(false);
//        System.out.println(McLaren.WheelSpeed(1000));
//        McLaren.ChangeGear(2);
//        System.out.println(McLaren.WheelSpeed(3000));
//        McLaren.OperateClutch(true);
//        McLaren.ChangeGear(3);
//        McLaren.OperateClutch(false);
//        System.out.println(McLaren.WheelSpeed(6000));
//
//        // Inner classes are probably going to be private anyway.

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached.");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        }

        btnPrint.setOnClickLister(new ClickListener());
        listen();

    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = userInput.nextInt();
            userInput.nextLine();
            switch  (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnPrint.onClick();
                    break;
            }
        }
    }
}
