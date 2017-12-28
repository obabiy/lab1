package com.company;

import java.util.Scanner;
public class Lab2{

    public static void main(String [] args){

        Scanner scan = new Scanner (System.in);


        System.out.print("Enter the number of medical cards: ");
        int num = scan.nextInt();

        Card cards[] = new Card[num];

        for(int i = 0;i<num; i++){
            Card temp = new Card();

            System.out.print("Surname: ");
            temp.Surname = scan.next();

            System.out.print("Name: ");
            temp.Name = scan.next();

            System.out.print("Year: ");
            temp.Year = scan.nextInt();

            System.out.print("Height: ");
            temp.Height = scan.nextDouble();

            System.out.print("Weight: ");
            temp.Weight = scan.nextDouble();
            cards[i] = temp;
            System.out.println();
        }


        for(int i = 0;i<num; i++){

            System.out.println(cards[i].Surname+" "+cards[i].Name+" "+cards[i].Year+" "+cards[i].Height+ " "+cards[i].Weight);
        }
    }

}
class Card{

    String Surname;
    String Name;
    int Year;
    double Height;
    double Weight;


}