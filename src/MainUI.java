package air;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainUI extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	JButton Search_airline; 
	JButton Search_place; 
	JButton Search_time;
	JButton Search_departrue_arrival;
	JButton Search_passenger; 
	JButton edit_AIRLINES; 
	JLabel jl1,jl2;
	JPanel jp1,jp2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainUI();
	}
	public MainUI(){//主界面
		jl1=new JLabel("Search:");
		jp1=new JPanel();
		jl2=new JLabel("Edit:");
		jp2=new JPanel();
		edit_AIRLINES=new JButton("EditAirlines");
		Search_airline=new JButton("airline");
		Search_place=new JButton("place");
		Search_time=new JButton("time");
		Search_departrue_arrival=new JButton("departrue/arrival");
		Search_passenger=new JButton("passenger");
		jp1.setLayout(new FlowLayout());  
		jp1.add(jl1);
		jp1.add(Search_airline);
		jp1.add(Search_place);
		jp1.add(Search_time);
		jp1.add(Search_departrue_arrival);
		jp1.add(Search_passenger);
		jp2.setLayout(new FlowLayout());  
		jp2.add(jl2);
		jp2.add(edit_AIRLINES);
		Search_airline.addActionListener(this);
		Search_airline.setActionCommand("airline");
		Search_passenger.addActionListener(this);
		Search_passenger.setActionCommand("passenger");
		Search_place.addActionListener(this);
		Search_place.setActionCommand("place");
		Search_departrue_arrival.addActionListener(this);
		Search_departrue_arrival.setActionCommand("departrue/arrival");
		Search_time.addActionListener(this);
		Search_time.setActionCommand("time");
		edit_AIRLINES.addActionListener(this);
		edit_AIRLINES.setActionCommand("editairlines");
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.setSize(600,150);
		this.setVisible(true);
		this.setTitle("MainUI");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("airline")){
			new Search_AirLine();//启动查询航班的界面
		}else if(arg0.getActionCommand().equals("passenger")){
			new Search_passenger();
		}else if(arg0.getActionCommand().equals("place")){
			new Search_place();
		}else if(arg0.getActionCommand().equals("departrue/arrival")){
			new Search_departrue_arrival();
		}else if(arg0.getActionCommand().equals("time")){
			new Search_time();
		}else if(arg0.getActionCommand().equals("editairlines")){
			new edit_AirLine();
		}
	}
	

}
