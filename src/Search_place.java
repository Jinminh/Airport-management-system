package air;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Search_place extends JFrame implements ActionListener{
	
	JLabel jl;
	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	Vector ans;
	public Search_place(){
		jl=new JLabel("Input place:");
		jta=new JTextArea(23,20);
		jtf=new JTextField(5);
		jb=new JButton("Search");
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		jp.setLayout(new FlowLayout());
		jp.add(jl);
		jp.add(jtf);
		jp.add(jb);
		jb.addActionListener(this);
		jb.setActionCommand("place");
		
		this.add(jp,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("Place");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("place")&&jtf.getText()!=null){
			jta.setText("");
			ans=(new Searchplace()).Search(jtf.getText());
			for(Object rst:ans){
				jta.append("Flightnumber:"+((Resultpl) rst).flightnumber+"  Source:"+((Resultpl) rst).source+"  Destination:"+((Resultpl) rst).des+"  PlaneCode:"+((Resultpl) rst).plane+"\n");
			}
		}
	}

}
