package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() {
		super();
		
	}
	
	public String os() {
	// Retorne o sistema operacional utilizado na máquina
		
		String os = System.getProperty("os.name"); 
		// retorna o nome do SO.
		
		String arch = System.getProperty("os.arch");
		//retorna a arquiterura do SO.
		
		String version = System.getProperty("os.version");
		// retorna a versão do SO.
		
		return os + " - v. "+ version + " - arch. "+arch;
		
	}
	
	
	public void callProcess(String process) {
		//Chama um processo
		
		try {
			Runtime.getRuntime().exec("cmd /c "+ process);
			//chama o processo como ADM no Windows
			
			Runtime.getRuntime().exec("sudo" + process);
			//chama o processo como ADM no Linux
			
			Runtime.getRuntime().exec(process);
			// chama o processo independente do SO.
			
		} catch (Exception e) {
		 String msgErro = e.getMessage();
		// System.err.println(msgErro);	
		 
		 if (msgErro.contains("740")) {
			 //  cmd /c caminho_do_processo
			 
			 StringBuffer buffer = new StringBuffer();
			 buffer.append("cmd /c");
			 buffer.append(" ");
			 buffer.append(process);
			 try {
				Runtime.getRuntime().exec(buffer.toString());
			} catch (IOException e1) {
			   e1.printStackTrace();
			}
			 
		 } else {
			 System.err.println(msgErro);
			 
		 }
		 
		}
	}

	
	public void readProcess(String process){
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
				
			}
				
			buffer.close();
			leitor.close();
			fluxo.close();
			
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

		
	
	