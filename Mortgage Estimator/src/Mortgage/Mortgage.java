package Mortgage;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Mortgage extends JFrame {
	
	private static final int WIDTH=450;
	private static final int HEIGHT=350;
	
	private static JLabel totalGrossIncomeL, totalMonthlyDebtL, mortgageInterestRateL, termL, downPaymentL,
	housingPaymentL, housingPaymentOtherObligationsL, maximumPaymentAllowedL, mortgageL;
	private static JTextField totalGrossIncomeTF, totalMonthlyDebtTF, mortgageInterestRateTF, termTF, downPaymentTF,
	housingPaymentTF, housingPaymentOtherObligationsTF, maximumPaymentAllowedTF, mortgageTF;
	private static JButton calculateB, exitB;
	
	private static CalculateButtonHandler cbHandler;
	private static ExitButtonHandler ebHandler;
	
	public static void Mortgage() {
		
		totalGrossIncomeL = new JLabel("Total Gross Income: ", SwingConstants.RIGHT);
		totalMonthlyDebtL = new JLabel("Total Monthly Debt: ", SwingConstants.RIGHT);
		mortgageInterestRateL = new JLabel("Mortgage Interest Rate: ", SwingConstants.RIGHT);
		termL = new JLabel("Term: ", SwingConstants.RIGHT);
		downPaymentL = new JLabel("Down Payment: ", SwingConstants.RIGHT);
		housingPaymentL = new JLabel("Housing Payment Only: ", SwingConstants.RIGHT);
		housingPaymentOtherObligationsL = new JLabel("Housing Payment + Other Obligations: ", SwingConstants.RIGHT);
		maximumPaymentAllowedL = new JLabel("Maximum Payment Allowed: ", SwingConstants.RIGHT);
		mortgageL = new JLabel("Amount of Mortgage that can be financed: ", SwingConstants.RIGHT);
		
		totalGrossIncomeTF = new JTextField(10);
		totalMonthlyDebtTF = new JTextField(10);
		mortgageInterestRateTF = new JTextField(10);
		termTF = new JTextField(10);
		downPaymentTF = new JTextField(10);
		housingPaymentTF = new JTextField(10);
		housingPaymentOtherObligationsTF = new JTextField(10);
		maximumPaymentAllowedTF = new JTextField(10);
		mortgageTF = new JTextField(10);
		
		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		JFrame frame = new JFrame();
		frame.setBounds(WIDTH,WIDTH,HEIGHT,HEIGHT);
		frame.setTitle("Mortgage");
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(5,2));
		
		pane.add(totalGrossIncomeL);
		pane.add(totalGrossIncomeTF);
		pane.add(totalMonthlyDebtL);
		pane.add(totalMonthlyDebtTF);
		pane.add(mortgageInterestRateL);
		pane.add(mortgageInterestRateTF);
		pane.add(termL);
		pane.add(termTF);
		pane.add(downPaymentL);
		pane.add(downPaymentTF);
		pane.add(housingPaymentL);
		pane.add(housingPaymentTF);
		pane.add(housingPaymentOtherObligationsL);
		pane.add(housingPaymentOtherObligationsTF);
		pane.add(maximumPaymentAllowedL);
		pane.add(maximumPaymentAllowedTF);
		pane.add(mortgageL);
		pane.add(mortgageTF);
		pane.add(calculateB);
		pane.add(exitB);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private static class CalculateButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			double totalGrossIncome, housingPayment, housingPaymentOtherObligations, maximumPaymentAllowed, term, mortgage, mortgageInterestRate;
			totalGrossIncome=Double.parseDouble(totalGrossIncomeTF.getText());
			housingPayment = .18*totalGrossIncome;
			housingPaymentTF.setText(""+ housingPayment);
			housingPaymentOtherObligations = .36*totalGrossIncome;
			housingPaymentOtherObligationsTF.setText(""+ housingPaymentOtherObligations);
			maximumPaymentAllowed = housingPayment;
			maximumPaymentAllowedTF.setText(""+ maximumPaymentAllowed);
			mortgageInterestRate = Double.parseDouble(mortgageInterestRateTF.getText());
			term = Double.parseDouble(termTF.getText());
			mortgage = (housingPayment/(mortgageInterestRate*( 1 - (Math.pow(1 + mortgageInterestRate, -(term*12))))));
			mortgageTF.setText(""+ mortgage);
			
		}
	}
	
	private static class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mortgage();

	}

}
