package air;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search_departrue_arrival extends JFrame implements ActionListener{
	
	JLabel jl;
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	Vector ans;
	JRadioButton rb1,rb2;
	public Search_departrue_arrival(){
		jl=new JLabel("Input arrivalID or departureID:");
		jta=new JTextArea(20,20);
		jtf=new JTextField(5);
		jb=new JButton("Search");
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		jp.setLayout(new FlowLayout());
		rb1 = new JRadioButton("arrivalID");
		rb2 = new JRadioButton("departureID");
		ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
		jp.add(jl);
		jp.add(jtf);
		jp.add(rb1);
		jp.add(rb2);
		jp.add(jb);
		
		jb.addActionListener(this);
		jb.setActionCommand("airline");
		
        rb1.setSelected(true);
		this.add(jp,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(600,500);
		this.setTitle("arrivalID or departureID");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("airline")&&jtf.getText()!=null){
			jta.setText("");
			if(rb1.isSelected()){
				ans=(new Searchdepartrue_arrival()).Search(jtf.getText(),1);
			}else{
				ans=(new Searchdepartrue_arrival()).Search(jtf.getText(),0);
			}
			for(Object rst:ans){
				jta.append("Firtsname:"+((Resultda) rst).fname+"  Lastname:"+((Resultda) rst).lname+"  Cityzenship:"+((Resultda) rst).cs+"  ArrivalID:"+((Resultda) rst).a+"  DepartureID:"+((Resultda) rst).d+"\n");
			}
		}
	}

}
