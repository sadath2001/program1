package com.example.demo;
//imports

@SpringBootApplication
public class DemoApplication {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	SpringApplication.run(DemoApplication.class, args);
    	ApplicationContext ac = new ClassPathXmlApplicationContext("testBean.xml");
    	Customer c = (Customer) ac.getBean("customer");
    	Ticket t = (Ticket) c.getTick();
    	while(true) {
    		System.out.println("1. insert the details\n 2. Display details \n"
    				+ "3. exit");
    		System.out.println("enter the choice");
    		int a = sc.nextInt();
    		switch(a) {
	    		case 1: 
	    			System.out.println("enter the customer name");
					c.setName(sc.next());
					System.out.println("enter the customer address");
					c.setAddress(sc.next());
					System.out.println("enter the ticket number");
					t.setTicno(sc.nextInt());
					System.out.println("enter the ticket seat no");
					t.setSeatno(sc.nextInt());
					System.out.println("enter the ticket price");
					t.setPrice(sc.nextInt());
					System.out.println("enter the ticket Type - economic/gold/platinum");
					t.setTicktype(sc.next());
					c.setTick(t);
					System.out.println("thanks for input");    		
					break;
	    		case 2: 
	    			System.out.println("Customer Details:");
	    			System.out.println("Name:"+c.getName()+" "+" Address:"+c.getAddress());
	    			System.out.println("Ticket Details");
	    			t = c.getTick();
	    			System.out.println("Ticket No: "+t.getTicno());
	    			System.out.println("Ticket Type: "+t.getTicktype());
	    			System.out.println("Ticket Seat No: "+t.getSeatno());
	    			System.out.println("Ticket Price: "+t.getPrice());
	    			break;
	    		case 3: 
	    			System.exit(0); 			
    		}    		
    	}    	
    }
}


<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		https://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="customer" 
	class="com.example.demo.Customer" 
	scope="prototype">
	      <property name="tick" ref="ticket"></property>
	</bean>
	
	<bean id="ticket" class="com.example.demo.Ticket" scope="prototype"/>
</beans>
