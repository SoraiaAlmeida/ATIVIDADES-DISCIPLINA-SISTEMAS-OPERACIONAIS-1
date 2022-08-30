package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}

	private String os() {
		return System.getProperty("os.name");
	}

	

	public void listaProcessos() {
		String comando = "";
		if (os().contains("Windows")) {
			comando = "TASKLIST /FO TABLE";
		} else if (os().contains("Linux")) {
			comando = "ps -ef";
		} else {
			System.err.println("OS nao suportado");
		}

		if (comando != "") {
			executaComando(comando);
		}
	}

	private void executaComando(String comando) {
		// TODO Auto-generated method stub
		
	}

	public void mataPid(int pid) {

		String comando = "";
		if (os().contains("Windows")) {
			comando = "TASKKILL /PID ";
		} else if (os().contains("Linux")) {
			comando = "kill -9 ";
		} else {
			System.err.println("OS nao suportado");
		}

		if (comando != "") {
			executaComando(comando + pid);
		}
	}

	public void mataNome(String nome) {
	String comando = "";
		if (os().contains("Windows")) {
			comando = "TASKKILL /IM ";
			if (!(nome.contains(".exe"))) {
				nome = nome + ".exe";
			}
		} else if (os().contains("Linux")) {
			comando = "pkill -f ";
		} else {
			System.err.println("OS nao suportado");
		}

		if (comando != "") {
			executaComando(comando + nome);
		}

	}
}