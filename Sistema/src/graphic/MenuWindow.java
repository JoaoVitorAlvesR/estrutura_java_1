package graphic;

import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import database.dao.UsuarioDAO;
import database.model.Usuario;
import util.BackupUtil;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLayeredPane;

public class MenuWindow extends JFrame{
	
	private JMenuBar mBar;
	private JMenu mSistema, mCadastro, mFinanceiro, mBackup;
	private JMenuItem mCerteza, mSairSim, mSairNao, mCadastroUsuario, mCadastroAlunos, mCadastroModalidade;
	private JDesktopPane desktop;
	private Connection conn;
	
	public MenuWindow(Connection conn, String perfil) {
		
		this.conn = conn;
		JFrame frame = new JFrame();
		
		mBar = new JMenuBar();
			mSistema = new JMenu("Sair");
				mCerteza = new JMenuItem("Tem Certeza?");
				mSairSim = new JMenuItem("Sim");
				mSairSim.setAction(new AbstractAction("Sim") {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				mSairNao = new JMenuItem("Não");
			
				mSistema.add(mCerteza);
				mSistema.add(mSairSim);
				mSistema.add(mSairNao);
				mCerteza.setEnabled(false);
			
			mBackup = new JMenu("Backup");
				mCerteza = new JMenuItem("Realizar Backup?");
				mSairSim = new JMenuItem("Sim");
				mSairSim.setAction(new AbstractAction("Sim") {

					@Override
					public void actionPerformed(ActionEvent e) {
						BackupUtil.makeBackup();
						
					}});
				mSairNao = new JMenuItem("Não");
				
				mBackup.add(mCerteza);
				mBackup.add(mSairSim);
				mBackup.add(mSairNao);
				mCerteza.setEnabled(false);
			
			mCadastro = new JMenu("Cadastro");
				mCadastroUsuario = new JMenuItem("Usuário");
				mCadastroUsuario.setAction(new AbstractAction("Usuário") {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						new CadastroUsuario(conn).setVisible(true);
						
					}
				});
				mCadastroAlunos = new JMenuItem("Alunos");
				mCadastroAlunos.setAction(new AbstractAction("Alunos") {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						CadastroAlunos caluno =  new CadastroAlunos(conn);
						desktop.add(caluno);
						
					}
				});
				
				mCadastroModalidade = new JMenuItem("Modalidades");
				mCadastroModalidade.setAction(new AbstractAction("Modalidades") {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						CadastroModalidade cmodalidade = new CadastroModalidade(conn);
						desktop.add(cmodalidade);						
					}
				});
				
			if(perfil.equals("Administrador")) {
				mCadastro.add(mCadastroUsuario);
			}
			mCadastro.add(mCadastroAlunos);
			mCadastro.add(mCadastroModalidade);
			
			mFinanceiro = new JMenu("Financeiro");
			
		mBar.add(mSistema);
		if(perfil.equals("Administrador")) {
			mBar.add(mBackup);
		}
		mBar.add(mCadastro);
		mBar.add(mFinanceiro);
		
		desktop = new JDesktopPane();
		
		frame.setContentPane(desktop);
		frame.setBounds(100, 100, 500, 600);
		frame.setJMenuBar(mBar);
		frame.setVisible(true);
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
