package graphic;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ErrorDialog extends JFrame {

	private JPanel contentPane;

	public ErrorDialog(String error) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{60, 30, 10, 30, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblErro = new JLabel("Erro!");
		lblErro.setFont(new Font("Dialog", Font.BOLD, 25));
		GridBagConstraints gbc_lblErro = new GridBagConstraints();
		gbc_lblErro.fill = GridBagConstraints.VERTICAL;
		gbc_lblErro.insets = new Insets(0, 0, 5, 0);
		gbc_lblErro.gridx = 0;
		gbc_lblErro.gridy = 0;
		contentPane.add(lblErro, gbc_lblErro);
		
		JLabel lblNewLabel = new JLabel(error);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setAction(new AbstractAction("OK") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
