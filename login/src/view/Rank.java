package view;

import javax.swing.JPanel;

public class Rank extends JPanel{

	public Rank(){
		JPanel rank = new JPanel();
		this.add(rank);
		this.setSize(1300,700);
		this.setVisible(true);
		this.setLayout(null);
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Rank();
	}

}
