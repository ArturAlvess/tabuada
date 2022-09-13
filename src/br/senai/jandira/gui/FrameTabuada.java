package br.senai.jandira.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.senai.jandira.model.Tabuada;

public class FrameTabuada {

	public String titulo;
	public int altura;
	public int largura;

	public void criarTela() {
	
		JFrame tela = new JFrame();

		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.getContentPane().setBackground(new Color(212, 230, 255));
		
		
		// Pegar o container para colocar os componentes
		Container painel = tela.getContentPane();

		// Criar componentes do container
		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		buttonCalcular.setBackground(new Color (94, 209, 61));
		buttonCalcular.setBounds(40, 330, 200, 50);
		
		JButton buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		buttonLimpar.setBackground(new Color (252, 186, 3));
		buttonLimpar.setBounds(250, 330, 150, 50);
		
		
		// Componentes TextField
		
		JTextField textFieldMult = new JTextField();
		textFieldMult.setBounds(260, 140, 160, 30);
		textFieldMult.setBorder(new LineBorder(new Color (41, 124, 196)));
		
		JTextField textFieldMin = new JTextField();
		textFieldMin.setBounds(260, 200, 160, 30);
		textFieldMin.setBorder(new LineBorder(new Color (41, 124, 196)));
		
		JTextField textFieldMax = new JTextField();
		textFieldMax.setBounds(260, 260, 160, 30);
		textFieldMax.setBorder(new LineBorder(new Color (41, 124, 196)));
		
		// Componentes Label
		
		JLabel titleTabuada = new JLabel();
		titleTabuada.setFont(new Font("Bahnschrift", Font.BOLD, 24));
		titleTabuada.setForeground(new Color(255, 10, 10));
		titleTabuada.setBackground(Color.white);
		titleTabuada.setText("Tabuada 1.0");
		titleTabuada.setBounds(80, 30, 200, 40);
		
		JLabel descricao = new JLabel();
		descricao.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		descricao.setText("Com a tabuada 1.0 os seus problemas acabaram."); 
		descricao.setBounds(80, 40, 500, 80);
		
		JLabel descricao2 = new JLabel();
		descricao2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		descricao2.setText("Calcule a tabuada que desejar em segundos!"); 
		descricao2.setBounds(80, 60, 500, 80);
		
		
		JLabel multiplicando = new JLabel();
		multiplicando.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		multiplicando.setText("Multiplicando: ");
		multiplicando.setForeground(new Color(61, 159, 245));
		multiplicando.setBounds(130, 120, 180, 80);
		
		JLabel minimo = new JLabel();
		minimo.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		minimo.setText("Mínimo Multiplicador: ");
		minimo.setForeground(new Color(61, 159, 245));
		minimo.setBounds(60, 180, 250, 80);
		
		
		JLabel maximo = new JLabel();
		maximo.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		maximo.setText("Máximo Multiplicador: ");
		maximo.setForeground(new Color(61, 159, 245));
		maximo.setBounds(60, 240, 250, 80);
		
		
		//Imagem 
		
		ImageIcon icon = new ImageIcon("C:\\Users\\22282175\\eclipse-workspace\\tabuada\\img-tabuada\\icon.png");
		JLabel LabelIcon = new JLabel(icon);
		LabelIcon.setBounds(10, 30, 70, 60);
		
		// Scroll Pane
		
		JScrollPane scrollResultado = new JScrollPane();
		scrollResultado.setBounds(15, 390, 400, 205);
		JList<String> listResultado = new JList<String>();
		listResultado.setBackground(new Color(252, 233, 164));
	
		
		// Colocar componentes no painel
		painel.add(buttonCalcular);
		painel.add(titleTabuada);
		painel.add(multiplicando);
		painel.add(minimo);
		painel.add(maximo);
		painel.add(descricao);
		painel.add(textFieldMult);
		painel.add(textFieldMin);
		painel.add(textFieldMax);
		painel.add(descricao2);
		painel.add(buttonLimpar);
		painel.add(listResultado);
		painel.add(scrollResultado);
		painel.add(LabelIcon);
		
		// painel visivel

				tela.setVisible(true);
		// listener para botão calcular
				
				buttonCalcular.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(textFieldMult.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "O multiplicando é obrigatório", "Erro!", JOptionPane.OK_OPTION);
							textFieldMult.requestFocus();
							
						} else if (textFieldMin.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "O mínimo multiplicador é obrigatório.", "Erro!", JOptionPane.OK_OPTION);
							textFieldMin.requestFocus();
						} else if (textFieldMax.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "O máximo multiplicador é obrigatório.", "Erro!", JOptionPane.OK_OPTION);
							textFieldMax.requestFocus();
							
						} else {
						Tabuada tabuada = new Tabuada();
						tabuada.multiplicando = Integer.parseInt(textFieldMult.getText());
						tabuada.minimoMultiplicador = Integer.parseInt(textFieldMin.getText());
						tabuada.maximoMultiplicador = Integer.parseInt(textFieldMax.getText());
						
						if (tabuada.maximoMultiplicador >= tabuada.minimoMultiplicador) {
							listResultado.setListData(tabuada.getTabuada());
							scrollResultado.getViewport().add(listResultado);
		
						} else {
							JOptionPane.showMessageDialog(null, "O mínimo multiplicador deve ser menor que o máximo.", "Erro!", JOptionPane.OK_OPTION);
							textFieldMult.setText("");
							textFieldMin.setText("");
							textFieldMax.setText("");
						}
						
						
							
						}
						
						
					}
				});
				
			// listener para o botão limpar	
				buttonLimpar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						DefaultListModel<String> listModel = new DefaultListModel<>();
						listResultado.setModel(listModel);
						textFieldMax.setText("");
						textFieldMin.setText("");
						textFieldMult.setText("");
						textFieldMult.requestFocus();
						
					}
				});
		
		
				
	}				
}
