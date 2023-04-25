
package util;
import java.io.File;

import javax.swing.JOptionPane;

public class BackupUtil {
	public static void makeBackup() {
		
		boolean runProcess = true;
	
	File diretorio = new File("./Backup");
	if(!diretorio.isDirectory()) {
		diretorio.mkdir();
	}
	
	String path = "./Backup/Sistema.dmp";
	File arquivoBackup = new File(path);
	
	if(arquivoBackup.isFile()) {
		if(JOptionPane.showConfirmDialog(null, "Já existe um arquivo de backup. Deseja sobrescrever?", "Informação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			arquivoBackup.delete();
			}else {
				runProcess = false;
			}
		}
	
	if(runProcess) {
		if(new File("./backupBanco.bat").isFile()) {
			Process process;
			try {
				process = Runtime.getRuntime().exec("./backupBanco.bat progress 12345 " +path);
				process.waitFor();
				int codigo = process.exitValue();
				if(codigo == 0) {
					JOptionPane.showMessageDialog(null, "Backup realizado com sucesso!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Falhou no Backup, Codigo: "+ codigo);
				}		
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Arquivo BAT não encontrado!");
			}
		}
	}
	
	}
}