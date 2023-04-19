package graphic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dao.UsuarioDAO;
import database.model.Usuario;
import main.Start;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JTextField;

public class LoginWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private Connection conn;

	public LoginWindow(Connection conn) {
		
		this.conn = conn;
		setBounds(100, 100, 300, 185);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{50, 75, 25, 100, 0};
		gbl_contentPanel.rowHeights = new int[]{30, 30, 30, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel_2 = new JLabel("Usuario:");
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = 1;
			contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.gridwidth = 3;
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Senha:");
			GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
			gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel_3.gridx = 0;
			gbc_lblNewLabel_3.gridy = 2;
			contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		}
		{
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.gridwidth = 3;
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 2;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		}
		{
			JButton okButton = new JButton(new AbstractAction("OK") {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						UsuarioDAO dao = new UsuarioDAO(conn);
						
						Usuario u = new Usuario();
						u.setUsuario(textField.getText());
						u.setSenha(textField_1.getText());
						
						List<Object> listaUsuario = dao.Select(u);
						
						if (listaUsuario.size() > 0) {
							Usuario usuario = (Usuario)listaUsuario.get(0);
							new MenuWindow(conn, usuario.getPerfil());
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválido!");
							textField.setText(null);
							textField_1.setText(null);
						}
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			GridBagConstraints gbc_okButton = new GridBagConstraints();
			gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_okButton.gridwidth = 2;
			gbc_okButton.insets = new Insets(0, 0, 0, 5);
			gbc_okButton.gridx = 0;
			gbc_okButton.gridy = 4;
			contentPanel.add(okButton, gbc_okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			GridBagConstraints gbc_cancelButton = new GridBagConstraints();
			gbc_cancelButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_cancelButton.gridwidth = 2;
			gbc_cancelButton.gridx = 2;
			gbc_cancelButton.gridy = 4;
			contentPanel.add(cancelButton, gbc_cancelButton);
			cancelButton.setAction(new AbstractAction("Cancel") {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
	}

}
