package graphic;

import java.awt.event.ActionEvent;
import java.sql.Connection;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import database.dao.UsuarioDAO;
import database.model.Usuario;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;

public class MenuWindow {
	
	private JMenuBar mBar;
	private JMenu mSistema, mCadastro, mFinanceiro;
	private JMenuItem mCerteza, mSairSim, mSairNao, mCadastroUsuario, mCadastroAlunos, mCadastroModalidade;
	private Connection conn;
	
	public MenuWindow(Connection conn, String perfil) {
		
		this.conn = conn;
		
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
			mCerteza.setEnabled(false);
			mSistema.add(mSairSim);
			mSistema.add(mSairNao);
			
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
						new CadastroAlunos(conn).setVisible(true);;
						
					}
				});
				mCadastroModalidade = new JMenuItem("Modalidades");
			if(perfil.equals("Administrador")) {
				mCadastro.add(mCadastroUsuario);
			}
			mCadastro.add(mCadastroAlunos);
			mCadastro.add(mCadastroModalidade);
			
			mFinanceiro = new JMenu("Financeiro");
			
		mBar.add(mSistema);
		mBar.add(mCadastro);
		mBar.add(mFinanceiro);
		
		JFrame frame = new JFrame();
		frame.setSize(700, 700);
		frame.setJMenuBar(mBar);
		frame.setVisible(true);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
