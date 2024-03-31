package com.example.LabCycle01;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LabCycle01Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SpringApplication.run(LabCycle01Application.class, args);
		ApplicationContext ac = new ClassPathXmlApplicationContext("custtick.xml");
		Customer cs = (Customer)ac.getBean("customer");
		Ticket t = (Ticket) cs.getTicket();
		
		while (true) {
			System.out.println("1. insert the details\n 2. Display details\n 3.exit");
			System.out.println("enter the choice");
			int a = sc.nextInt();
			switch (a) {
			case 1:
				System.out.println("enter the customer name");
				cs.setName(sc.next());
				System.out.println("enter the customer address");
				cs.setAddress(sc.next());
				System.out.println("enter the ticket number");
				t.setTicno(sc.nextInt());
				System.out.println("enter the ticket seat no");
				t.setSeatno(sc.nextInt());
				System.out.println("enter the ticket price");
				t.setPrice(sc.nextInt());
				System.out.println("enter the ticket type - economic/gold/platinum");
				t.setTicktype(sc.next());
				cs.setTicket(t);
				System.out.println("thanks for input");
				break;
			case 2:
				System.out.println("Customer Details");
				System.out.println("Name:" + cs.getName() + " " + " Address:" + cs.getAddress());
				System.out.println("ticket details");
				t = cs.getTicket();
				System.out.println("tick no: " + t.getTicno());
				System.out.println("ticket type: " + t.getTicktype());
				System.out.println("ticker seat no: " + t.getSeatno());
				System.out.println("ticket price: " + t.getPrice());
				break;
			case 3:
				System.exit(0);
			}

		}
	}
}
