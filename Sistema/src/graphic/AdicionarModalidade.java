package graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dao.MatriculaDAO;
import database.dao.MatriculaModalidadeDAO;
import database.dao.ModalidadeDAO;
import database.model.MatriculaModalidade;
import database.model.MatriculaModel;
import database.model.Modalidade;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AdicionarModalidade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private Connection conn;
	
	

	public AdicionarModalidade(Connection conn, int codigoAluno) {
		this.conn = conn;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{5, 0, 100, 5, 0, 100, 0};
		gbl_contentPane.rowHeights = new int[]{5, 0, 5, 30, 30, 30, 30, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setAction(new AbstractAction("Voltar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salvar");
		btnNewButton_1.setAction(new AbstractAction("Salvar") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			try {
				MatriculaModalidadeDAO dao = new MatriculaModalidadeDAO(conn);
				MatriculaModalidade m = new MatriculaModalidade();
				
				MatriculaDAO matriculaDao = new MatriculaDAO(conn);
				MatriculaModel mm = new MatriculaModel();
				mm.setCodigo_aluno(codigoAluno);
				
				List<Object> listMatricula = matriculaDao.Select(mm);
				mm = (MatriculaModel) listMatricula.get(0);
								
				m.setCodigoMatricula(mm.getCodigo_matricula());
;				
				m.setModalidade(comboBox.getSelectedItem().toString());
				m.setGraduacao(comboBox_1.getSelectedItem().toString());
				m.setPlano(comboBox_2.getSelectedItem().toString());
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

				String dateInStringIni = textField.getText();
				Date dateIni = new Date();
				
				String dateInStringFim = textField_1.getText();
				//Date dateFim = new Date();
				try {
					dateIni = (Date) formatter.parse(dateInStringIni);
					//dateFim = (Date) formatter.parse(dateInStringFim);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				m.setDataInicio(textField.getText().isEmpty()?null:new java.sql.Date(dateIni.getTime()));
				//m.setDataFim(textField_1.getText().isEmpty()?null:new java.sql.Date(dateFim.getTime()));
			    				
				dao.Insert(m);
				new ConfirmaSalvar().setVisible(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				new ErrorDialog("").setVisible(true);
			}
			
			}
		});
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Modalidade:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"- Selecione -"}));
		ModalidadeDAO dao = null;
		
		try {
			dao = new ModalidadeDAO(conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<Object> Modalidades = new ArrayList<>();
		try {
			Modalidades = dao.SelectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		for(int i=0; i< Modalidades.size(); i++) {
			Modalidade modalidade = (Modalidade) Modalidades.get(i);
			comboBox.addItem(modalidade.getModalidade());	
		}
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Graduação:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		

		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"- Selecione -"}));
		comboBox_1.addItem("Iniciante");
		comboBox_1.addItem("Intermediário");
		comboBox_1.addItem("Avançado");
		
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 4;
		contentPane.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Plano:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"- Selecione -"}));
		comboBox_2.addItem("Semanal");
		comboBox_2.addItem("Mensal");
		comboBox_2.addItem("Bimestral");
		comboBox_2.addItem("Trimestral");
		comboBox_2.addItem("Semestral");
		comboBox_2.addItem("Anual");
		

		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.gridwidth = 4;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 2;
		gbc_comboBox_2.gridy = 5;
		contentPane.add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data Início:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data Fim:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 6;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
	}

}
