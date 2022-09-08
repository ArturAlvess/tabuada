package br.senai.sp.jandira;

import br.senai.jandira.gui.FrameTabuada;
import br.senai.jandira.model.Tabuada;

public class AppTabuada {

	public static void main(String[] args) {
		
		
		FrameTabuada tela = new FrameTabuada();
		tela.titulo = "Tabuada";
		tela.largura = 450;
		tela.altura = 700;
		tela.criarTela();
		
		Tabuada usuario = new Tabuada();
		usuario.multiplicando = 3;
		usuario.minimoMultiplicador = 8;
		usuario.maximoMultiplicador = 43;
		
		
		String[] resultado = usuario.getTabuada();
		
		int i = 0;
		while (i < resultado.length) {
			System.out.println(resultado[i]);
			i++;
		}
		
	
			}

}
