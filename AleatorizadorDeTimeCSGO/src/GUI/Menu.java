package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JButton;
import javax.management.timer.Timer;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import codes.Recursos;

public class Menu extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField nome1;
	private JTextField nome2;
	private JTextField nome3;
	private JTextField nome4;
	private JTextField nome5;
	private JTextField nome6;
	private JTextField nome7;
	private JTextField nome8;
	private JTextField nome9;
	private JTextField nome10;
	private JLabel l5,l6,l7,l8,l9,l10;
	private JLabel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
	private JButton gerar, limpar, limparTimes, ajuda, mais;
	private JTextField textField;
	private JTextField textField_1;
	private JList lista;
	private JButton carregar, excluir, salvar;
	private JRadioButton dezP, quatroP;
	private ButtonGroup grupoP = new ButtonGroup();

	public Menu() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/iconcsgo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setTitle("Aleatorizador de Time CSGO");
		setResizable(false);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// TUDO SOBRE A LISTA DOS NOMES SALVOS
		lista = new JList();
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(lista);
		scroll.setBounds(475, 26, 135, 98);
		contentPane.add(scroll);
		try {
			// carregar os nomes na lista
			String[] nomes = Recursos.leituraFilenamesIni();
			Vector aux = new Vector();
			for(int i=0; i<lista.getModel().getSize(); i++) {
				aux.add(lista.getModel().getElementAt(i));
			}
			for(int i=0; i<nomes.length; i++) {
				if(nomes[i] != null)
					aux.add(nomes[i]);
			}
			lista.setListData(aux);
			//****
			
		}catch(NullPointerException n) {
			new File("savedNames").mkdir();
			File f = new File("readme.txt");
			try {
				FileWriter fr = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fr);
				
				String texto = "NÃO MODIFIQUE NADA DENTRO DOS ARQUIVOS QUE TEM NA PASTA SAVEDNAMES POIS PODE FAZER O PROGRAMA PARAR DE FUNCIONAR!";
				String texto1 = "Caso queira adicionar uma lista diretamente crie um arquivo txt na pasta savedNames e faça igual como vai ser demonstrado a seguir."; 
				String texto2 = "Você deve seguir esta ordem";
				String texto3 = "NúmeroDePlayers;Nome0;Nome1;Nome2;...;";
				String texto4 = "Número de players só pode 4 ou 10, caso não for nenhum dos dois a lista não vai carregar e depois do números você coloca o ponto e virgula ';'";
				String texto5 = "Exemplo: ";
				String texto6 = "4;José;Maria;Carlos;Ana;";
				String texto7 = "ESTE README É GERADO JUNTO COM A PASTA SAVEDNAMES ENTÃO SE VOCÊ DELETAR ESSE README ELE SÓ VAI SER GERADO NOVAMENTE CASO A PASTA FOR DELETADA.";
				
				pw.println(texto);
				pw.println(texto1);
				pw.println(texto2);
				pw.println(texto3);
				pw.println(texto4);
				pw.println(texto5);
				pw.println(texto6);
				pw.println(texto7);
				
				pw.close();
			}catch(IOException e) {
				JOptionPane.showMessageDialog(null, "ERRO: Falha ao criar o arquivo readme!");
				e.printStackTrace();
			}
		}
		
		carregar = new JButton("Carregar");
		carregar.setBounds(620, 26, 89, 23);
		carregar.addActionListener(this);
		contentPane.add(carregar);
		
		excluir = new JButton("Excluir");
		excluir.setBounds(620, 78, 89, 23);
		excluir.addActionListener(this);
		contentPane.add(excluir);
		
		salvar = new JButton("Salvar");
		salvar.setBounds(620, 52, 89, 23);
		salvar.addActionListener(this);
		contentPane.add(salvar);
		
		// *****
		
		dezP = new JRadioButton("10 Players");
		dezP.setBackground(Color.WHITE);
		dezP.setSelected(true);
		dezP.setBounds(186, 7, 85, 20);
		dezP.addActionListener(this);
		contentPane.add(dezP);
		
		quatroP = new JRadioButton("4 Players");
		quatroP.setBackground(Color.WHITE);
		quatroP.addActionListener(this);
		quatroP.setBounds(186, 27, 85, 20);
		contentPane.add(quatroP);
		
		grupoP.add(dezP);
		grupoP.add(quatroP);
		
		JLabel lblNome = new JLabel("Nome 1:");
		lblNome.setForeground(Color.RED);
		lblNome.setBackground(Color.WHITE);
		lblNome.setBounds(10, 10, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblNome_1 = new JLabel("Nome 2:");
		lblNome_1.setForeground(Color.RED);
		lblNome_1.setBounds(10, 50, 46, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblNome_2 = new JLabel("Nome 3:");
		lblNome_2.setForeground(Color.RED);
		lblNome_2.setBounds(10, 90, 46, 14);
		contentPane.add(lblNome_2);
		
		JLabel label_2 = new JLabel("Nome 4:");
		label_2.setForeground(Color.RED);
		label_2.setBounds(10, 130, 46, 14);
		contentPane.add(label_2);
		
		l5 = new JLabel("Nome 5:");
		l5.setForeground(Color.RED);
		l5.setBounds(10, 170, 46, 14);
		contentPane.add(l5);
		
		l6 = new JLabel("Nome 6:");
		l6.setForeground(Color.RED);
		l6.setBounds(10, 210, 46, 14);
		contentPane.add(l6);
		
		l7 = new JLabel("Nome 7:");
		l7.setForeground(Color.RED);
		l7.setBounds(10, 250, 46, 14);
		contentPane.add(l7);
		
		l8 = new JLabel("Nome 8:");
		l8.setForeground(Color.RED);
		l8.setBounds(10, 290, 46, 14);
		contentPane.add(l8);
		
		l9 = new JLabel("Nome 9:");
		l9.setForeground(Color.RED);
		l9.setBounds(10, 330, 46, 14);
		contentPane.add(l9);
		
		l10 = new JLabel("Nome 10:");
		l10.setForeground(Color.RED);
		l10.setBounds(10, 370, 58, 14);
		contentPane.add(l10);
		
		nome1 = new JTextField();
		nome1.setBounds(76, 7, 100, 20);
		contentPane.add(nome1);
		nome1.setColumns(10);
		
		nome2 = new JTextField();
		nome2.setBounds(76, 47, 100, 20);
		contentPane.add(nome2);
		nome2.setColumns(10);
		
		nome3 = new JTextField();
		nome3.setBounds(76, 87, 100, 20);
		contentPane.add(nome3);
		nome3.setColumns(10);
		
		nome4 = new JTextField();
		nome4.setBounds(76, 127, 100, 20);
		contentPane.add(nome4);
		nome4.setColumns(10);
		
		nome5 = new JTextField();
		nome5.setBounds(76, 167, 100, 20);
		contentPane.add(nome5);
		nome5.setColumns(10);
		
		nome6 = new JTextField();
		nome6.setBounds(76, 207, 100, 20);
		contentPane.add(nome6);
		nome6.setColumns(10);
		
		nome7 = new JTextField();
		nome7.setBounds(76, 247, 100, 20);
		contentPane.add(nome7);
		nome7.setColumns(10);
		
		nome8 = new JTextField();
		nome8.setBounds(76, 287, 100, 20);
		contentPane.add(nome8);
		nome8.setColumns(10);
		
		nome9 = new JTextField();
		nome9.setBounds(76, 327, 100, 20);
		contentPane.add(nome9);
		nome9.setColumns(10);
		
		nome10 = new JTextField();
		nome10.setBounds(76, 367, 100, 20);
		contentPane.add(nome10);
		nome10.setColumns(10);
		
		JLabel lblTime = new JLabel("Time 1");
		lblTime.setForeground(Color.RED);
		lblTime.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblTime.setBounds(343, 5, 85, 17);
		contentPane.add(lblTime);
		
		p1 = new JLabel("");
		p1.setForeground(Color.RED);
		p1.setBounds(346, 30, 119, 14);
		contentPane.add(p1);
		
		p2 = new JLabel("");
		p2.setForeground(Color.RED);
		p2.setBounds(346, 50, 119, 14);
		contentPane.add(p2);
		
		p3 = new JLabel("");
		p3.setForeground(Color.RED);
		p3.setBounds(346, 70, 428, 14);
		contentPane.add(p3);
		
		p4 = new JLabel("");
		p4.setForeground(Color.RED);
		p4.setBounds(346, 90, 428, 14);
		contentPane.add(p4);
		
		p5 = new JLabel("");
		p5.setForeground(Color.RED);
		p5.setBounds(346, 110, 428, 14);
		contentPane.add(p5);
		
		JLabel lblTime_1 = new JLabel("Time 2");
		lblTime_1.setBackground(Color.GREEN);
		lblTime_1.setForeground(Color.RED);
		lblTime_1.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblTime_1.setBounds(343, 150, 82, 17);
		contentPane.add(lblTime_1);
		
		p6 = new JLabel("");
		p6.setForeground(Color.RED);
		p6.setBounds(346, 175, 428, 14);
		contentPane.add(p6);
		
		p7 = new JLabel("");
		p7.setForeground(Color.RED);
		p7.setBounds(346, 195, 428, 14);
		contentPane.add(p7);
		
		p8 = new JLabel("");
		p8.setForeground(Color.RED);
		p8.setBounds(346, 215, 428, 14);
		contentPane.add(p8);
		
		p9 = new JLabel("");
		p9.setForeground(Color.RED);
		p9.setBounds(346, 235, 428, 14);
		contentPane.add(p9);
		
		p10 = new JLabel("");
		p10.setForeground(Color.RED);
		p10.setBounds(346, 255, 428, 14);
		contentPane.add(p10);
		
		gerar = new JButton("Gerar");
		gerar.setForeground(Color.GREEN);
		gerar.setBounds(76, 398, 100, 23);
		contentPane.add(gerar);
		gerar.addActionListener(this);
		
		limpar = new JButton("Limpar");
		limpar.setForeground(new Color(128, 0, 0));
		limpar.setBounds(76, 432, 100, 23);
		contentPane.add(limpar);
		limpar.addActionListener(this);
		
		limparTimes = new JButton("Limpar Times");
		limparTimes.setForeground(new Color(128, 0, 0));
		limparTimes.setBounds(330, 282, 135, 30);
		contentPane.add(limparTimes);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(Color.BLACK);
		textField.setBounds(330, 27, 135, 100);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(330, 172, 135, 100);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("By JawwadBr");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBounds(10, 531, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("V1.2.4");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setBounds(10, 546, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		ajuda = new JButton("Ajuda");
		ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ajuda) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos em branco com o nomes dos jogadores, logo após clique em 'Gerar'.\n"
							+ "Caso você clicar 'Gerar' novamente com os mesmos nomes escritos o programa irá gerar outra formação do time com os nomes já inseridos.\n"
							+ "Caso queira apagar todos os nomes clique em 'Limpar'.\n"
							+ "O botão Limpar Time é só estética, pois caso tenha algum nome bugado ou apenas queira que saia os nomes anteriores o programa vai setar o valor padrão.\n"
							+ "Na area de nomes salvos serveg para salvar uma lista de nomes, para usar é simples basta inserir os nomes em relação a sua escolha da quantidade de jogadores"
							+ " e depois\nde preencher clicar em salvar e digitar um nome para a lista que você lembre e saiba quais nomes tem ali. Para pegar de volta esses nomes é só clicar no "
							+ "nome da lista e clicar em 'Carregar'.", "Como Funciona o programa", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		ajuda.setBounds(186, 398, 89, 23);
		contentPane.add(ajuda);
		
		mais = new JButton("Mais");
		mais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == mais) {
					JOptionPane.showMessageDialog(null, "Talvez implementar no futuro:\nNo momento tudo implementado!" , "Mais", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		mais.setBounds(186, 432, 89, 23);
		contentPane.add(mais);
		
		JLabel lblNomesSalvos = new JLabel("Nomes salvos:");
		lblNomesSalvos.setForeground(Color.RED);
		lblNomesSalvos.setBounds(475, 10, 89, 14);
		contentPane.add(lblNomesSalvos);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/data/imgcs.jpg")));
		lblNewLabel.setBounds(0, 0, 795, 571);
		contentPane.add(lblNewLabel);
		limparTimes.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dezP) {
			dezPMetodo();
		}
		else if(e.getSource() == quatroP) {
			quatroPMetodo();
		}
		if(e.getSource() == gerar) {
			if(testaVazioNomes() == false && dezP.isSelected()) {
				String[] nomes = pegaNomes();
				Recursos.aleatorizaArray10(nomes);
				insereNomes(nomes); 
			}
			else if(testaVazioNomes() == false && quatroP.isSelected()) {
				String[] nomes = pegaNomes();
				Recursos.aleatorizaArray4(nomes);
				insereNomes(nomes);
			}
			else
				JOptionPane.showMessageDialog(null, "ERRO: Preencha os Nomes!", "ErrorNoNames", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == limpar) {
			int op = JOptionPane.showConfirmDialog(null, "Deseja mesmo limpar todos os nomes?", "Selecione uma das Opções", JOptionPane.INFORMATION_MESSAGE);
			if(op == 0)
				limpaNomes();
		}
		else if(e.getSource() == limparTimes) {
			limpaTimes();
		}
		else if(e.getSource() == salvar) {
			if(testaVazioNomes() == false) {
				String filename = JOptionPane.showInputDialog(null, "Insira o nome de referência: \nExemplo: Padrão Time MIX BMC 10players", "Salvar lista dos nomes", JOptionPane.INFORMATION_MESSAGE);
				if(filename.equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(null, "ERRO: Caixa de nome vazio!", "ErrorListName", JOptionPane.INFORMATION_MESSAGE);
				else
					if(!testaExisteLista(filename)) {
						String[] nomes = getTodosNomes();
						Recursos.escrita(filename, nomes);
						Vector aux = new Vector();
						for(int i=0; i<lista.getModel().getSize(); i++) {
							aux.add(lista.getModel().getElementAt(i));
					}
						aux.add(filename);
						lista.setListData(aux);
					}
					else
						JOptionPane.showMessageDialog(null, "ERRO: Este nome de lista já existe!", "ErrorListName", JOptionPane.INFORMATION_MESSAGE);
			}
			else
				JOptionPane.showMessageDialog(null, "ERRO: Preencha os Nomes antes de salvar uma lista!", "ErrorNoNamesForList", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == excluir) {
			try {
					int opc = JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir esta lista ?");
					if(opc == 0) {
						if(Recursos.deletarArquivo(String.valueOf(lista.getModel().getElementAt(lista.getSelectedIndex())))) {
							Vector aux = new Vector();
							for(int i=0; i<lista.getModel().getSize(); i++) {
								aux.add(lista.getModel().getElementAt(i));
							}
							aux.remove(lista.getSelectedIndex());
							lista.setListData(aux);
					}
					
				}
			}catch(ArrayIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "ERRO: Escolha uma lista primeiro!", "IndexOutOfBounds", JOptionPane.INFORMATION_MESSAGE);
			}catch(IndexOutOfBoundsException i) {
				JOptionPane.showMessageDialog(null, "ERRO: Crie listas primeiro!", "IndexOutOfBounds", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == carregar) {
			limpaNomes();
			try {
				if(lista.getModel().getSize() == 0) {
					JOptionPane.showMessageDialog(null, "ERRO: Crie uma lista primeiro!", "NoListCreated", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					String[] nomes = Recursos.leitura(String.valueOf(lista.getModel().getElementAt(lista.getSelectedIndex())));
					if(nomes.length < 5 && nomes.length > 11) {
						JOptionPane.showMessageDialog(null, "ERRO: Lista com tamanho diferente ao padrão!", "ListInvalidIndex", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(nomes.length == 5) {
						quatroP.setSelected(true);
						quatroPMetodo();
					}
					else if(nomes.length == 11) {
						dezP.setSelected(true);
						dezPMetodo();
					}
					insereNomesField(nomes);
				}
				
			}catch(ArrayIndexOutOfBoundsException a) {
				JOptionPane.showMessageDialog(null, "ERRO: Lista com tamanho diferente ao padrão ou nenhuma lista foi selecionada!", "IndexOutOfBounds", JOptionPane.INFORMATION_MESSAGE);
				limpaTimes();
			}
		}
		contentPane.repaint();
	}


	public JLabel getP1() {
		return p1;
	}

	public JLabel getP2() {
		return p2;
	}

	public JLabel getP3() {
		return p3;
	}

	public JLabel getP4() {
		return p4;
	}

	public JLabel getP5() {
		return p5;
	}

	public JLabel getP6() {
		return p6;
	}

	public JLabel getP7() {
		return p7;
	}

	public JLabel getP8() {
		return p8;
	}

	public JLabel getP9() {
		return p9;
	}

	public JLabel getP10() {
		return p10;
	}

	public JButton getGerar() {
		return gerar;
	}

	public JButton getLimpar() {
		return limpar;
	}

	public void setP1(JLabel p1) {
		this.p1 = p1;
	}

	public void setP2(JLabel p2) {
		this.p2 = p2;
	}

	public void setP3(JLabel p3) {
		this.p3 = p3;
	}

	public void setP4(JLabel p4) {
		this.p4 = p4;
	}

	public void setP5(JLabel p5) {
		this.p5 = p5;
	}

	public void setP6(JLabel p6) {
		this.p6 = p6;
	}

	public void setP7(JLabel p7) {
		this.p7 = p7;
	}

	public void setP8(JLabel p8) {
		this.p8 = p8;
	}

	public void setP9(JLabel p9) {
		this.p9 = p9;
	}

	public void setP10(JLabel p10) {
		this.p10 = p10;
	}

	public void setGerar(JButton gerar) {
		this.gerar = gerar;
	}

	public void setLimpar(JButton limpar) {
		this.limpar = limpar;
	}
	
	
	public JTextField getNome1() {
		return nome1;
	}

	public JTextField getNome2() {
		return nome2;
	}

	public JTextField getNome3() {
		return nome3;
	}

	public JTextField getNome4() {
		return nome4;
	}

	public JTextField getNome5() {
		return nome5;
	}

	public JTextField getNome6() {
		return nome6;
	}

	public JTextField getNome7() {
		return nome7;
	}

	public JTextField getNome8() {
		return nome8;
	}

	public JTextField getNome9() {
		return nome9;
	}

	public JTextField getNome10() {
		return nome10;
	}

	public void setNome1(JTextField nome1) {
		this.nome1 = nome1;
	}

	public void setNome2(JTextField nome2) {
		this.nome2 = nome2;
	}

	public void setNome3(JTextField nome3) {
		this.nome3 = nome3;
	}

	public void setNome4(JTextField nome4) {
		this.nome4 = nome4;
	}

	public void setNome5(JTextField nome5) {
		this.nome5 = nome5;
	}

	public void setNome6(JTextField nome6) {
		this.nome6 = nome6;
	}

	public void setNome7(JTextField nome7) {
		this.nome7 = nome7;
	}

	public void setNome8(JTextField nome8) {
		this.nome8 = nome8;
	}

	public void setNome9(JTextField nome9) {
		this.nome9 = nome9;
	}

	public void setNome10(JTextField nome10) {
		this.nome10 = nome10;
	}

	public JLabel getL5() {
		return l5;
	}

	public JLabel getL6() {
		return l6;
	}

	public JLabel getL7() {
		return l7;
	}

	public JLabel getL8() {
		return l8;
	}

	public JLabel getL9() {
		return l9;
	}

	public JLabel getL10() {
		return l10;
	}

	public void setL5(JLabel l5) {
		this.l5 = l5;
	}

	public void setL6(JLabel l6) {
		this.l6 = l6;
	}

	public void setL7(JLabel l7) {
		this.l7 = l7;
	}

	public void setL8(JLabel l8) {
		this.l8 = l8;
	}

	public void setL9(JLabel l9) {
		this.l9 = l9;
	}

	public void setL10(JLabel l10) {
		this.l10 = l10;
	}

	public String[] pegaNomes() {
		if(dezP.isSelected()) {
			String[] retorno = new String[10];
			retorno[0] = getNome1().getText();
			retorno[1] = getNome2().getText();
			retorno[2] = getNome3().getText();
			retorno[3] = getNome4().getText();
			retorno[4] = getNome5().getText();
			retorno[5] = getNome6().getText();
			retorno[6] = getNome7().getText();
			retorno[7] = getNome8().getText();
			retorno[8] = getNome9().getText();
			retorno[9] = getNome10().getText();
			return retorno;
		}
		else {
			String[] retorno = new String[4];
			retorno[0] = getNome1().getText();
			retorno[1] = getNome2().getText();
			retorno[2] = getNome3().getText();
			retorno[3] = getNome4().getText();
	 		return retorno;
		}
	}
	
	public void insereNomes(String[] nomes) {
		if(dezP.isSelected()) {
			getP1().setText(nomes[0]);
			getP2().setText(nomes[1]);
			getP3().setText(nomes[2]);
			getP4().setText(nomes[3]);
			getP5().setText(nomes[4]);
			getP6().setText(nomes[5]);
			getP7().setText(nomes[6]);
			getP8().setText(nomes[7]);
			getP9().setText(nomes[8]);
			getP10().setText(nomes[9]);
		}
		else {
			getP1().setText(nomes[0]);
			getP2().setText(nomes[1]);
			getP6().setText(nomes[2]);
			getP7().setText(nomes[3]);
		}
	}
	
	public void insereNomesField(String[] nomes) {
		if(dezP.isSelected()) {
			getNome1().setText(nomes[1]);
			getNome2().setText(nomes[2]);
			getNome3().setText(nomes[3]);
			getNome4().setText(nomes[4]);
			getNome5().setText(nomes[5]);
			getNome6().setText(nomes[6]);
			getNome7().setText(nomes[7]);
			getNome8().setText(nomes[8]);
			getNome9().setText(nomes[9]);
			getNome10().setText(nomes[10]);
		}
		else {
			getNome1().setText(nomes[1]);
			getNome2().setText(nomes[2]);
			getNome3().setText(nomes[3]);
			getNome4().setText(nomes[4]);
		}
	}
	
	public void limpaNomes() {
		getNome1().setText("");
		getNome2().setText("");
		getNome3().setText("");
		getNome4().setText("");
		getNome5().setText("");
		getNome6().setText("");
		getNome7().setText("");
		getNome8().setText("");
		getNome9().setText("");
		getNome10().setText("");
	}
	
	public void limpaTimes() {
		getP1().setText("");
		getP2().setText("");
		getP3().setText("");
		getP4().setText("");
		getP5().setText("");
		getP6().setText("");
		getP7().setText("");
		getP8().setText("");
		getP9().setText("");
		getP10().setText("");
	}
	
	//True vazio | false com nomes
	public boolean testaVazioNomes() {
		if(dezP.isSelected() && !getNome1().getText().equals("") && !getNome2().getText().equals("") && !getNome3().getText().equals("") && !getNome4().getText().equals("") && !getNome5().getText().equals("") 
		   && !getNome6().getText().equals("") && !getNome7().getText().equals("") && !getNome8().getText().equals("") && !getNome9().getText().equals("") && !getNome10().getText().equals("")) {
			return false;
		}
		else if(quatroP.isSelected() && !getNome1().getText().equals("") && !getNome2().getText().equals("") && !getNome3().getText().equals("") && !getNome4().getText().equals("")) {
			return false;
		}
		return true;
	}
	
	public String[] getTodosNomes() {
		String[] retorno;
		if(dezP.isSelected()) {
			retorno = new String[10];
			retorno[0] = getNome1().getText();
			retorno[1] = getNome2().getText();
			retorno[2] = getNome3().getText();
			retorno[3] = getNome4().getText();
			retorno[4] = getNome5().getText();
			retorno[5] = getNome6().getText();
			retorno[6] = getNome7().getText();
			retorno[7] = getNome8().getText();
			retorno[8] = getNome9().getText();
			retorno[9] = getNome10().getText();
			return retorno;
		}
		retorno = new String[4];
		retorno[0] = getNome1().getText();
		retorno[1] = getNome2().getText();
		retorno[2] = getNome3().getText();
		retorno[3] = getNome4().getText();			
		return retorno;
	}
	
	public boolean testaExisteLista(String filename) {
		for(int i=0; i<lista.getModel().getSize(); i++) {
			if(filename.equalsIgnoreCase(lista.getModel().getElementAt(i).toString())) {
				return true;
			}
		}
		return false;
	}
	
	public void dezPMetodo() {
		limpaTimes();
		getNome5().setVisible(true);
		getL5().setVisible(true);
		getNome6().setVisible(true);
		getL6().setVisible(true);
		getNome7().setVisible(true);
		getL7().setVisible(true);
		getNome8().setVisible(true);
		getL8().setVisible(true);
		getNome9().setVisible(true);
		getL9().setVisible(true);
		getNome10().setVisible(true);
		getL10().setVisible(true);
		
		gerar.setBounds(76, 398, 100, 23);
		ajuda.setBounds(186, 398, 89, 23);
		
		limpar.setBounds(76, 432, 100, 23);
		mais.setBounds(186, 432, 89, 23);
	}
	
	public void quatroPMetodo() {
		limpaTimes();
		getNome5().setVisible(false);
		getL5().setVisible(false);
		getNome6().setVisible(false);
		getL6().setVisible(false);
		getNome7().setVisible(false);
		getL7().setVisible(false);
		getNome8().setVisible(false);
		getL8().setVisible(false);
		getNome9().setVisible(false);
		getL9().setVisible(false);
		getNome10().setVisible(false);
		getL10().setVisible(false);
		
		gerar.setBounds(76, 151, 100, 23);
		ajuda.setBounds(186, 151, 89, 23);
		
		limpar.setBounds(76, 182, 100, 23);
		mais.setBounds(186, 182, 89, 23);
	}
}
