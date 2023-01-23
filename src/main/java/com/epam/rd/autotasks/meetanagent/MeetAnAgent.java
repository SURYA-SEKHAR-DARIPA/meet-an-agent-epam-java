package com.epam.rd.autotasks.meetanagent;
import java.util.*;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here
        Scanner sc=new Scanner(System.in);
        int c=sc.nextInt();
        if(c==PASSWORD){
            System.out.println("Hello, Agent");
        }
        else{System.out.println("Access denied");}

    }
}
