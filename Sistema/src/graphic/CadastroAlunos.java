package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dao.AlunoDAO;
import database.dao.UsuarioDAO;
import database.model.Aluno;
import database.model.Usuario;

import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CadastroAlunos extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtAluno;
	private JTextField txtCpf;
	private JTextField txtSexo;
	private JTextField txtDataNascimento;
	private JTextField txtTelefone;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtNumero;
	private JTextField txtEndereco;
	private JTextField txtComplemento;
	private JTextField txtEstado;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtPais;
	private JTextField txtObservacao;
	private Connection conn;	


	public CadastroAlunos(Connection conn) {
		this.conn = conn;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 455, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 75, 75, 75, 75, 0};
		gbl_contentPane.rowHeights = new int[]{30, 30, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BuscarAluno(conn).setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnCriarAluno = new JButton("Adicionar");
		btnCriarAluno.setAction(new AbstractAction("Adicionar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO dao = new AlunoDAO(conn);
					Aluno a = new Aluno();
					a.setAluno(txtAluno.getText().isEmpty()?null:txtAluno.getText());
					a.setData_nascimento(txtDataNascimento.getText());
					a.setSexo(txtSexo.getText());
					System.out.println(txtSexo.getText());
					a.setTelefone(txtTelefone.getText());
					a.setCelular(txtCelular.getText());
					a.setEmail(txtEmail.getText());
					a.setObservacao(txtObservacao.getText());
					a.setEndereco(txtEndereco.getText());
					a.setNumero(txtNumero.getText());
					a.setComplemento(txtComplemento.getText());
					a.setBairro(txtBairro.getText());
					a.setCidade(txtCidade.getText());
					a.setEstado(txtEstado.getText());
					a.setPais(txtPais.getText());
					a.setCep(txtCep.getText());
					a.setCpf(txtCpf.getText());
					
					dao.Insert(a);
					new ConfirmaSalvar().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					new ErrorDialog("colunas obrigatórias sendo enviadas vazias").setVisible(true);
				}
			}
		});
		
		
		GridBagConstraints gbc_btnCriarAluno = new GridBagConstraints();
		gbc_btnCriarAluno.gridwidth = 2;
		gbc_btnCriarAluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCriarAluno.insets = new Insets(0, 0, 5, 5);
		gbc_btnCriarAluno.gridx = 1;
		gbc_btnCriarAluno.gridy = 0;
		contentPane.add(btnCriarAluno, gbc_btnCriarAluno);
		
		JButton btnNewButton_2 = new JButton("Remover");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 2;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 0;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Salvar");
		btnNewButton_3.setAction(new AbstractAction("Salvar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO dao = new AlunoDAO(conn);
					Aluno a = new Aluno();
					a.setAluno(txtAluno.getText().isEmpty()?null:txtAluno.getText());
					a.setData_nascimento(txtDataNascimento.getText());
					a.setSexo(txtSexo.getText());
					System.out.println(txtSexo.getText());
					a.setTelefone(txtTelefone.getText());
					a.setCelular(txtCelular.getText());
					a.setEmail(txtEmail.getText());
					a.setObservacao(txtObservacao.getText());
					a.setEndereco(txtEndereco.getText());
					a.setNumero(txtNumero.getText());
					a.setComplemento(txtComplemento.getText());
					a.setBairro(txtBairro.getText());
					a.setCidade(txtCidade.getText());
					a.setEstado(txtEstado.getText());
					a.setPais(txtPais.getText());
					a.setCep(txtCep.getText());
					a.setCpf(txtCpf.getText());
					
					dao.Insert(a);
					new ConfirmaSalvar().setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					new ErrorDialog("colunas obrigatórias sendo enviadas vazias").setVisible(true);
				}
			}
		});
		
		
		
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.gridwidth = 2;
		gbc_btnNewButton_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 1;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setAction(new AbstractAction("Voltar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.gridwidth = 3;
		gbc_btnVoltar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 0);
		gbc_btnVoltar.gridx = 2;
		gbc_btnVoltar.gridy = 1;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 3;
		contentPane.add(lblNome, gbc_lblNome);
		
		txtAluno = new JTextField();
		GridBagConstraints gbc_txtAluno = new GridBagConstraints();
		gbc_txtAluno.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAluno.gridwidth = 3;
		gbc_txtAluno.insets = new Insets(0, 0, 5, 0);
		gbc_txtAluno.gridx = 1;
		gbc_txtAluno.gridy = 3;
		contentPane.add(txtAluno, gbc_txtAluno);
		txtAluno.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 4;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		txtCpf = new JTextField();
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.gridwidth = 3;
		gbc_txtCpf.insets = new Insets(0, 0, 5, 0);
		gbc_txtCpf.gridx = 1;
		gbc_txtCpf.gridy = 4;
		contentPane.add(txtCpf, gbc_txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtSexo = new JTextField();
		GridBagConstraints gbc_txtSexo = new GridBagConstraints();
		gbc_txtSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSexo.gridwidth = 3;
		gbc_txtSexo.insets = new Insets(0, 0, 5, 0);
		gbc_txtSexo.gridx = 1;
		gbc_txtSexo.gridy = 5;
		contentPane.add(txtSexo, gbc_txtSexo);
		txtSexo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nascimento:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 6;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtDataNascimento = new JTextField();
		GridBagConstraints gbc_txtDataNascimento = new GridBagConstraints();
		gbc_txtDataNascimento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDataNascimento.gridwidth = 3;
		gbc_txtDataNascimento.insets = new Insets(0, 0, 5, 0);
		gbc_txtDataNascimento.gridx = 1;
		gbc_txtDataNascimento.gridy = 6;
		contentPane.add(txtDataNascimento, gbc_txtDataNascimento);
		txtDataNascimento.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 7;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtTelefone = new JTextField();
		GridBagConstraints gbc_txtTelefone = new GridBagConstraints();
		gbc_txtTelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTelefone.gridwidth = 3;
		gbc_txtTelefone.insets = new Insets(0, 0, 5, 0);
		gbc_txtTelefone.gridx = 1;
		gbc_txtTelefone.gridy = 7;
		contentPane.add(txtTelefone, gbc_txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Celular:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 8;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtCelular = new JTextField();
		GridBagConstraints gbc_txtCelular = new GridBagConstraints();
		gbc_txtCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCelular.gridwidth = 3;
		gbc_txtCelular.insets = new Insets(0, 0, 5, 0);
		gbc_txtCelular.gridx = 1;
		gbc_txtCelular.gridy = 8;
		contentPane.add(txtCelular, gbc_txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 9;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridwidth = 3;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 9;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CEP:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 10;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtCep = new JTextField();
		GridBagConstraints gbc_txtCep = new GridBagConstraints();
		gbc_txtCep.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCep.gridwidth = 3;
		gbc_txtCep.insets = new Insets(0, 0, 5, 0);
		gbc_txtCep.gridx = 1;
		gbc_txtCep.gridy = 10;
		contentPane.add(txtCep, gbc_txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Endereço:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 11;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtEndereco = new JTextField();
		GridBagConstraints gbc_txtEndereco = new GridBagConstraints();
		gbc_txtEndereco.gridwidth = 3;
		gbc_txtEndereco.insets = new Insets(0, 0, 5, 0);
		gbc_txtEndereco.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEndereco.gridx = 1;
		gbc_txtEndereco.gridy = 12;
		contentPane.add(txtEndereco, gbc_txtEndereco);
		txtEndereco.setColumns(10);
		
		txtNumero = new JTextField();
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.gridwidth = 3;
		gbc_txtNumero.insets = new Insets(0, 0, 5, 0);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 11;
		contentPane.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Número:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 12;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		
		
		JLabel lblNewLabel_8 = new JLabel("Complemento:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 13;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		txtComplemento = new JTextField();
		GridBagConstraints gbc_txtComplemento = new GridBagConstraints();
		gbc_txtComplemento.gridwidth = 3;
		gbc_txtComplemento.insets = new Insets(0, 0, 5, 0);
		gbc_txtComplemento.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtComplemento.gridx = 1;
		gbc_txtComplemento.gridy = 13;
		contentPane.add(txtComplemento, gbc_txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Bairro:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 14;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		txtBairro = new JTextField();
		GridBagConstraints gbc_txtBairro = new GridBagConstraints();
		gbc_txtBairro.gridwidth = 3;
		gbc_txtBairro.insets = new Insets(0, 0, 5, 0);
		gbc_txtBairro.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBairro.gridx = 1;
		gbc_txtBairro.gridy = 14;
		contentPane.add(txtBairro, gbc_txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Cidade:");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 15;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtCidade = new JTextField();
		GridBagConstraints gbc_txtCidade = new GridBagConstraints();
		gbc_txtCidade.gridwidth = 3;
		gbc_txtCidade.insets = new Insets(0, 0, 5, 0);
		gbc_txtCidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCidade.gridx = 1;
		gbc_txtCidade.gridy = 15;
		contentPane.add(txtCidade, gbc_txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Estado:");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 16;
		contentPane.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		txtEstado = new JTextField();
		GridBagConstraints gbc_txtEstado = new GridBagConstraints();
		gbc_txtEstado.gridwidth = 3;
		gbc_txtEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEstado.gridx = 1;
		gbc_txtEstado.gridy = 16;
		contentPane.add(txtEstado, gbc_txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("País:");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 17;
		contentPane.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		txtPais = new JTextField();
		GridBagConstraints gbc_txtPais = new GridBagConstraints();
		gbc_txtPais.gridwidth = 3;
		gbc_txtPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPais.gridx = 1;
		gbc_txtPais.gridy = 17;
		contentPane.add(txtPais, gbc_txtPais);
		txtPais.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Observações:");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 18;
		contentPane.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		txtObservacao = new JTextField();
		GridBagConstraints gbc_txtObservacao = new GridBagConstraints();
		gbc_txtObservacao.gridwidth = 3;
		gbc_txtObservacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtObservacao.gridx = 1;
		gbc_txtObservacao.gridy = 18;
		contentPane.add(txtObservacao, gbc_txtObservacao);
		txtObservacao.setColumns(10);	
		setIconifiable(true);
		setClosable(true);
		setVisible(true);
		setTitle("Cadastro de Alunos");
	}
}