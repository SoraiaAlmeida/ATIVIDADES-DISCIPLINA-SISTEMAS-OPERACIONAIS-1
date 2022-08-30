package view;

import controller.KillController;

public class Principal {

	public static void main(String[] args) {
		
				KillController kill = new KillController();
				
				kill.listaProcessos();
				kill.mataPid(13468);
				kill.mataNome("EXCEL");
			}

	}


