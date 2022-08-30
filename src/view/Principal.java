package view;

import controller.RedesController;

public class Principal {

	public static void main(String[] args) {
		
		RedesController RedesController = new RedesController();
		
		
		
		String os = RedesController.os();
		System.out.println(os);
		
		String process = "ipconfig";
		RedesController.readProcess(process);
		
	   //String process = "TASKLIST /FO TABLE";
	  // RedesController.callProcess(process);

	
	}
}

