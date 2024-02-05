package edu.examples.java_classes.main;

import edu.examples.java_classes.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		
		String request;
		String response;
		
		request = "ADD\ntitle=Книга\nсоntent=Туманность Андромеды";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "ADD\ntitle=Книга\nсоntent=Остор на птичьей улице\ndate=2022-01-02";
		response = controller.doAction(request);
		System.out.println(response);
		
		
		request = "UPDATE\nid=2\ntitle=Книга\ncontent=Туманность Андромеды\ndate=2023-08-08";
		response = controller.doAction(request);
		System.out.println(response);	
		
		request = "GET_ALL_NOTES\n";
		response = controller.doAction(request);
		System.out.println(response);	
		
		request = "FIND_CONTENS\ncontent=Туманность Андромеды";
		response = controller.doAction(request);
		System.out.println(response);
		
		request = "FIND_DATE\ndate=2022-01-02";
		response = controller.doAction(request);
		System.out.println(response);
	}

}
