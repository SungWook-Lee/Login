package view;

import java.awt.Color;

import javax.swing.*;

public class Status extends JPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Status("tester","�̼���","23","M","180.3","70.0","80.0");
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

		//���̵�
		IDField.setBounds(100,50,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		IDField.setOpaque(false); // �����ϰ� �ϱ� 
		IDField.setForeground(Color.BLACK);
		IDField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(IDField); // �гο� ���� 

		//�̸�
		NameField.setBounds(100,100,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		NameField.setOpaque(false); // �����ϰ� �ϱ� 
		NameField.setForeground(Color.BLACK);
		NameField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(NameField);
		
		//��
		GenderField.setBounds(100,150,280,30);
		GenderField.setOpaque(false);
		GenderField.setForeground(Color.BLACK);
		GenderField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(GenderField);

		//����
		AgeField.setBounds(100,200,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		AgeField.setOpaque(false); // �����ϰ� �ϱ� 
		AgeField.setForeground(Color.BLACK);
		AgeField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(AgeField);

		//Ű
		HeightField.setBounds(100,250,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		HeightField.setOpaque(false); // �����ϰ� �ϱ� 
		HeightField.setForeground(Color.BLACK);
		HeightField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(HeightField);
		
		//������
		WeightField.setBounds(100,300,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		WeightField.setOpaque(false); // �����ϰ� �ϱ� 
		WeightField.setForeground(Color.BLACK);
		WeightField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(WeightField);
		
		//��ǥ
		GoalField.setBounds(100,350,280,30); //�α��� �ؽ�Ʈ �ʵ� ��ġ 
		GoalField.setOpaque(false); // �����ϰ� �ϱ� 
		GoalField.setForeground(Color.BLACK);
		GoalField.setBorder(javax.swing.BorderFactory.createEmptyBorder());//�����ϰ� �ϱ� 
		layeredPane.add(GoalField);


		this.add(layeredPane);
		this.setVisible(true);
		this.setLayout(null);
		this.setSize(1300,700);

	}

}
