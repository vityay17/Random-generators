package Main;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Algorytmy.*;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;

public class Window {

	JFrame frame;
	JPanel panel;
	
	public Window() {
		
		initialize();
	}
	
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Segoe UI Light", Font.PLAIN, 14));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 960, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[237px][697px]", "[448px]"));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "cell 0 0,alignx left,growy");
		panel_1.setLayout(new MigLayout("", "[68px][4px][151px]", "[20px][20px][20px][21px][20px][21px][23px][21px][24px][23px][23px]"));
		
		JLabel lblNewLabel = new JLabel("Zakres od:");
		panel_1.add(lblNewLabel, "cell 0 2,alignx right,growy");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		JLabel lblGenerator = new JLabel("Generator:");
		panel_1.add(lblGenerator, "cell 0 1,alignx right,growy");
		lblGenerator.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 2 1,growx,aligny top");
		comboBox.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LCG", "MLCG", "kwadratowy", "addytywny"}));
		
		JSpinner spinnerZakresOd = new JSpinner();
		panel_1.add(spinnerZakresOd, "cell 2 2,growx,aligny top");
		
		JLabel lblA = new JLabel("a:");
		panel_1.add(lblA, "cell 0 5,alignx right,growy");
		lblA.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		JLabel lblDo = new JLabel("do:");
		panel_1.add(lblDo, "cell 0 3,alignx right,growy");
		lblDo.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		JSpinner spinnerZakresDo = new JSpinner();
		panel_1.add(spinnerZakresDo, "cell 2 3,growx,aligny bottom");
		
		spinnerZakresDo.setValue(1000);
		lblDo.setLabelFor(spinnerZakresDo);
										
		JSpinner spinnerA = new JSpinner();
		panel_1.add(spinnerA, "cell 2 5,growx,aligny bottom");
		spinnerA.setValue(234);
		
		JLabel lblZiarno = new JLabel("Ziarno:");
		panel_1.add(lblZiarno, "cell 0 4,alignx right,growy");
		lblZiarno.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		JSpinner spinnerZiarno = new JSpinner();
		panel_1.add(spinnerZiarno, "cell 2 4,growx,aligny top");
		spinnerZiarno.setValue(123);
		
		JLabel lblNewLabel_1 = new JLabel("Parametry");
		panel_1.add(lblNewLabel_1, "cell 0 0 3 1,growx,aligny top");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblB = new JLabel("b:");
		lblB.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		panel_1.add(lblB, "cell 0 6,alignx right,aligny center");
		
		JSpinner spinnerB = new JSpinner();
		panel_1.add(spinnerB, "cell 2 6,grow");
		
		JLabel lblC = new JLabel("c:");
		panel_1.add(lblC, "cell 0 7,alignx right,growy");
		lblC.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		JSpinner spinnerC = new JSpinner();
		panel_1.add(spinnerC, "cell 2 7,growx,aligny bottom");
		spinnerC.setValue(435);
		
		JLabel lblM = new JLabel("m:");
		panel_1.add(lblM, "cell 0 8,alignx right,growy");
		lblM.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		JSpinner spinnerM = new JSpinner();
		panel_1.add(spinnerM, "cell 2 8,growx,aligny bottom");
		spinnerM.setValue(4352345);
		
		JButton btnNewButton = new JButton("Wyczy\u015B\u0107 parametry");
		panel_1.add(btnNewButton, "cell 0 9 3 1,grow");
		btnNewButton.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spinnerM.setValue(0);
				spinnerA.setValue(0);
				spinnerC.setValue(0);
				spinnerZiarno.setValue(0);
				spinnerZakresOd.setValue(0);
				spinnerZakresDo.setValue(0);
			}
		});
		
		JButton btnGeneruj = new JButton("Generuj");
		panel_1.add(btnGeneruj, "cell 0 10 3 1,growx,aligny top");
		btnGeneruj.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 11));
		
		btnGeneruj.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			long a = new Long((Integer)spinnerA.getValue());
			long b = new Long((Integer)spinnerB.getValue());
			long c = new Long((Integer)spinnerC.getValue());
			long m = new Long((Integer)spinnerM.getValue());
			long x = new Long((Integer)spinnerZiarno.getValue());
			int n = 1000;
			long low = new Long((Integer)spinnerZakresOd.getValue());
			long high = new Long((Integer)spinnerZakresDo.getValue());
			
			double[]k = null;
			if(comboBox.getSelectedItem() == "LCG")
				k = new LCG().main(m, a, c, x, n, low, high);
			if(comboBox.getSelectedItem() == "MLCG")
				k = new MLCG().main(m, a, x, n, low, high);
			if(comboBox.getSelectedItem() == "kwadratowy")
				k = new Kwadratowy().main(a,b, c, m, x, n, low, high);
			if(comboBox.getSelectedItem() == "addytywny")
				k = new Addytywny().main(c, m, x, n, low, high);
		
			new Histogram(panel).display(k);
		}
		});
		
		spinnerB.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 1 0,grow");
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem() == "MLCG"){
					spinnerA.setEnabled(true);
					spinnerC.setEnabled(false);
					spinnerB.setEnabled(false);
				}
				else if (comboBox.getSelectedItem() == "LCG"){
					spinnerA.setEnabled(true);
					spinnerB.setEnabled(false);
					spinnerC.setEnabled(true);
				}
				else if (comboBox.getSelectedItem() == "kwadratowy"){
					spinnerA.setEnabled(true);
					spinnerB.setEnabled(true);
					spinnerC.setEnabled(true);
				}
				else if (comboBox.getSelectedItem() == "addytywny"){
					spinnerA.setEnabled(false);
					spinnerB.setEnabled(false);
				}
			}
		});
	
	}

}
