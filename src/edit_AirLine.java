package air;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class edit_AirLine extends JFrame implements ActionListener{
	
	static JTable jta;
	
	JButton jb1,jb2,jb3;
	JPanel jp;
	JPanel jp2;
	JLabel jl1,jl2,jl3;
	JTextField jtf1,jtf2,jtf3;
	JScrollPane jsp;
	Vector ans;
	
	Vector vc;
	static Vector title=new Vector();
	static DefaultTableModel model=new DefaultTableModel(title,0);
	
	public edit_AirLine(){
		title.clear();
		title.addElement("NAME");
		title.addElement("CODE");
		title.addElement("WEBSITE");
		jp2=new JPanel();
		jl1=new JLabel("NAME:");
		jl2=new JLabel("CODE:");
		jl3=new JLabel("WEBSITE:");
		jtf1=new JTextField(5);
		jtf2=new JTextField(5);
		jtf3=new JTextField(5);
		jta=new JTable(model);
		jb1=new JButton("submit edit");
		jb2=new JButton("delete");
		jb3=new JButton("add");
		jp2.setLayout(new FlowLayout());
		jp2.add(jl1);
		jp2.add(jtf1);
		jp2.add(jl2);
		jp2.add(jtf2);
		jp2.add(jl3);
		jp2.add(jtf3);
		jp2.add(jb3);
		jp2.add(jb1);
		jp2.add(jb2);
		jsp=new JScrollPane(jta);
		jb1.addActionListener(this);
		jb1.setActionCommand("edit");
		jb2.addActionListener(this);
		jb2.setActionCommand("delete");
		jb3.addActionListener(this);
		jb3.setActionCommand("add");
		this.refresh();
		this.add(jp2,BorderLayout.NORTH);
		this.add(jsp,BorderLayout.SOUTH);
		this.setVisible(true);
		this.setSize(700,500);
		this.setTitle("EditAirLine");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("edit")){
			
			if(!(new editAirline()).edit()){
				JOptionPane.showMessageDialog(null, "Update failed!",
						"ERROR!", JOptionPane.ERROR_MESSAGE);
			}
			refresh();
		}else if (e.getActionCommand().equals("delete")){
			if(!(new editAirline()).delete()){
				JOptionPane.showMessageDialog(null, "Delete failed!",
						"ERROR!", JOptionPane.ERROR_MESSAGE);
			}
			refresh();
		}else if (e.getActionCommand().equals("add")&&!jtf1.getText().equals("")&&!jtf2.getText().equals("")&&!jtf3.getText().equals("")){
			if(!(new editAirline()).add(jtf1.getText(),jtf2.getText(),jtf3.getText())){
				JOptionPane.showMessageDialog(null, "Add failed!",
						"ERROR!", JOptionPane.ERROR_MESSAGE);
			}
			refresh();
		}
	}
	public void refresh(){
		model.setRowCount(0);
		ans=(new editAirline()).Search();
		for(Object rst:ans){
			vc=new Vector();
			vc.clear();
			vc.add(((Resulta) rst).name);
			vc.add(((Resulta) rst).code);
			vc.add(((Resulta) rst).website);
			model.addRow(vc);
		}
	}

}
