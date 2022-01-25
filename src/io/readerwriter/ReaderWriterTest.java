package io.readerwriter;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReaderWriterTest
{
	public static void main( String args[])
	{
		UIForm3 ui = new UIForm3();
		ui.addLayout();
		ui.eventProc();	
	}	
}

//========================================
//	화면을 관리하는 클래스 
//----------------------------------------
class UIForm3 extends JFrame
{
	JTextArea	ta;
	JButton 		bSave, bLoad, bClear;
	
	UIForm3()
	{
		ta		= new JTextArea();		
		bSave 	= new JButton("파일저장");
		bLoad	= new JButton("파일읽기");
		bClear	= new JButton("화면지우기");
	}
	
	void addLayout()
	{
		JPanel pCenter 	= new JPanel();
		pCenter.setLayout( new BorderLayout() );
		//pCenter.add("Center", ta );  --> 옛날방식
		pCenter.add(ta, BorderLayout.CENTER);
	
		JPanel pSouth	= new JPanel();
		pSouth.add( bSave );
		pSouth.add( bLoad );
		pSouth.add( bClear );
		
		getContentPane().add("Center", pCenter );
		getContentPane().add("South",  pSouth );
		
		setSize( 400, 350 );
		setVisible( true );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	void eventProc()
	{
		// "저장하기" 버튼이 눌렸을 
		bSave.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent ev ){
				saveData();
			}
		});
		
		// "읽어오기" 버튼이 눌렸을 때
		bLoad.addActionListener(new ActionListener() { 
			public void actionPerformed( ActionEvent ev ){
				readData();
			}
		});	
		
	}
	
	void saveData() {
		JFileChooser fd = new JFileChooser();
		int returnValue = fd.showSaveDialog( null );  //저장버튼
		if( returnValue == JFileChooser.APPROVE_OPTION ) //저장 버튼을 눌렀을 때만 저장하기
		{
			File f = fd.getSelectedFile();    //시용자가 파일을 선택할 수 있게
			try{
				/** 
				 * @@@@@@@@@@@@@@@@@@@@@@@@@
				 * */
				FileWriter out = new FileWriter(f);  //문자를 주고 받는 가상통로
				
				out.write(ta.getText());
				
				out.close();
				
			}catch(Exception ex){
				System.out.println("저장 실패");
			}	
		}
	}
	
	void readData() {
		JFileChooser fd = new JFileChooser();
		int returnValue = fd.showOpenDialog(null);  //열기 버튼
		if( returnValue == JFileChooser.APPROVE_OPTION )
		{
			File f = fd.getSelectedFile();
		
		try {
			FileReader in = new FileReader(f);  //가상통로
			char[] result = new char[1024];    //얼마나 들어올 지 모르니까 배열 선언
			in.read(result);					// 선언한 배열에 있는 파일 읽기
			
			in.close();
			ta.setText(String.valueOf(result) );  //읽어온 파일 text area에 넣기
		}catch(Exception ex){
			System.out.println("저장 실패");
		}	
	}
}
	
}	

