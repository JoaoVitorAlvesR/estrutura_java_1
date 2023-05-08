package graphic;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BuscarAluno extends JFrame {

	private Connection conn;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public BuscarAluno(Connection conn) {
		this.conn = conn;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 0};
		gbl_contentPane.rowHeights = new int[]{5, 30, 5, 30, 30, 5, 100, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblCpf = new JLabel("CPF:");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.fill = GridBagConstraints.VERTICAL;
		gbc_lblCpf.gridwidth = 2;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 4;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 6;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setAction(new AbstractAction("Buscar") {

			@Override
			public void actionPerformed(ActionEvent e) {
			    String nome = textField.getText();
			    try {
			        Statement stmt = conn.createStatement();
			        ResultSet rs = stmt.executeQuery("SELECT * FROM alunos WHERE aluno iLIKE '%" + nome + "%'");

			        DefaultTableModel model = new DefaultTableModel(new String[] {"Nome", "CPF", "Codigo", "Telefone"}, 0);
			        while(rs.next()) {
//			            Date birthdate = rs.getDate("data_nascimento");
//			            Calendar calendar = Calendar.getInstance();
//			            calendar.setTime(birthdate);
//			            int birthYear = calendar.get(Calendar.YEAR);
//			            int birthMonth = calendar.get(Calendar.MONTH);
//			            int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
//			            calendar.setTime(new Date());
//			            int currentYear = calendar.get(Calendar.YEAR);
//			            int currentMonth = calendar.get(Calendar.MONTH);
//			            int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
//			            int age = currentYear - birthYear;
//			            if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
//			                age--;
//			            }
			            model.addRow(new Object[] {rs.getString("aluno"), rs.getString("cpf"), rs.getInt("codigo_aluno"), rs.getString("telefone")});
			        }

			        JTable table = new JTable(model);
			        scrollPane.setViewportView(table);

			    } catch (Exception ex) {
			        ex.printStackTrace();
			    }
			}
			
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridwidth = 3;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Preencher");
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 1;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setAction(new AbstractAction("Voltar") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridwidth = 3;
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridwidth = 6;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		
	}
}
