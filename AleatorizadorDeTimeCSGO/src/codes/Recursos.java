package codes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;


public class Recursos {
	public static void aleatorizaArray10(String[] array) {
		for(int i=0; i<array.length; i++) {
			String aux = array[i];
			int num = (int)(Math.random()*10);
			array[i] = array[num];
			array[num] = aux;
		}
	}
	
	public static void aleatorizaArray4(String[] array) {
		for(int i=0; i<array.length; i++) {
			String aux = array[i];
			int num = (int)(Math.random()*4);
			array[i] = array[num];
			array[num] = aux;
		}
	}
	
	public static String[] leituraFilenamesIni() {
		File file = new File("savedNames/");
		File[] listOfFiles = file.listFiles();
		String[] retorno = new String[listOfFiles.length];
	    for(int i=0; i<listOfFiles.length;) 
	      if(listOfFiles[i].isFile()) {
	    	  String nome = listOfFiles[i].getName().replace(".txt", "");
	    	  if(nome.equals("readme")) {i++;}
	    	  else {
	    		  retorno[i] = nome;	
	    		  i++;
	    	  }
	      }
		return retorno;
	}
	
	public static String[] leitura(String arquivo) {
		try {
            FileReader fr = new FileReader("savedNames/"+arquivo+".txt");
            BufferedReader in = new BufferedReader(fr);
            String line = in.readLine();
            String[] retorno;
            do{
            	String[] texto = line.split(";");
            	retorno = new String[texto.length];
            	for(int i=0; i<texto.length; i++) {
            		retorno[i] = texto[i];
            	}
            	
            	line = in.readLine();
            	
            }while(line != null);
            in.close();
            return retorno;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo \""+arquivo+"\" não existe.");
        } catch (IOException e) {
            System.out.println("Erro na leitura de " + arquivo+".");
        }
		return null;
	}
	
	public static void escrita(String filename, String[] nomes) {
		try{
			FileOutputStream fl = new FileOutputStream(new File(String.format("savedNames/%s.txt", filename)));
			fl.write(String.valueOf(nomes.length).getBytes());
			fl.write(";".getBytes());
			for(int i=0; i<nomes.length; i++) {
				if(nomes[i] != null) {
					String nome = nomes[i];
					fl.write(String.format("%s;", nome).getBytes());
				}
			}
			fl.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static boolean deletarArquivo(String filename) {
		try{
    		File file = new File(String.format("savedNames/%s.txt", filename));
    		if(file.delete()){
    			JOptionPane.showMessageDialog(null, "A lista "+file.getName().replace(".txt", "")+" foi deletado!");
    			return true;
    		}else{
    			JOptionPane.showMessageDialog(null, "A lista "+file.getName().replace(".txt", "")+" não foi deletado com sucesso!");
    			return false;
    		}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return false;
	}
}
