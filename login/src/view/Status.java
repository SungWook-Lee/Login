package view;

import java.awt.Color;

import javax.swing.*;

public class Status extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Status("tester","이성욱","23","M","180.3","70.0","80.0");
	}
	public Status(String id,String name, String age, String gender,String height, String weight,String goal){

		JTextField IDField = new JTextField(id);
		JTextField NameField = new JTextField(name);
		JTextField AgeField = new JTextField(age);
		JTextField GenderField = new JTextField(gender);
		JTextField HeightField = new JTextField(height);
		JTextField WeightField = new JTextField(weight);
		JTextField GoalField = new JTextField(goal);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0,0,1300,700);
		layeredPane.setLayout(null);

		//아이디
		IDField.setBounds(100,50,280,30); //로그인 텍스트 필드 위치 
		IDField.setOpaque(false); // 투명하게 하기 
		IDField.setForeground(Color.BLACK);
		IDField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(IDField); // 패널에 놓기 

		//이름
		NameField.setBounds(100,100,280,30); //로그인 텍스트 필드 위치 
		NameField.setOpaque(false); // 투명하게 하기 
		NameField.setForeground(Color.BLACK);
		NameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(NameField);
		
		//성
		GenderField.setBounds(100,150,280,30);
		GenderField.setOpaque(false);
		GenderField.setForeground(Color.BLACK);
		GenderField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(GenderField);

		//나이
		AgeField.setBounds(100,200,280,30); //로그인 텍스트 필드 위치 
		AgeField.setOpaque(false); // 투명하게 하기 
		AgeField.setForeground(Color.BLACK);
		AgeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(AgeField);

		//키
		HeightField.setBounds(100,250,280,30); //로그인 텍스트 필드 위치 
		HeightField.setOpaque(false); // 투명하게 하기 
		HeightField.setForeground(Color.BLACK);
		HeightField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(HeightField);
		
		//몸무게
		WeightField.setBounds(100,300,280,30); //로그인 텍스트 필드 위치 
		WeightField.setOpaque(false); // 투명하게 하기 
		WeightField.setForeground(Color.BLACK);
		WeightField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(WeightField);
		
		//목표
		GoalField.setBounds(100,350,280,30); //로그인 텍스트 필드 위치 
		GoalField.setOpaque(false); // 투명하게 하기 
		GoalField.setForeground(Color.BLACK);
		GoalField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//투명하게 하기 
		layeredPane.add(GoalField);


		this.add(layeredPane);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1300,700);

	}

}
