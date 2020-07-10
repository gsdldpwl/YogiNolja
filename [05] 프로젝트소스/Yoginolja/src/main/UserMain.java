package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class UserMain {
	
	private static Scanner scan = new Scanner(System.in);
	private static String menuNum = null;
	
	public static void main(String[] args) {	
		UserLogin();	
	}
	
	public static void UserLogin() {
		
		String id;
		String pw;
		DBUtil util = new DBUtil();
		
		while(true) {
			
		System.out.println("============================================================");
		System.out.println("\t\t[���� �α���]");
		System.out.println("============================================================");
		
		System.out.print("\t\tid : ");
		id = scan.nextLine();
		System.out.print("\t\tpw : ");
		pw = scan.nextLine();
		
		//�α��� ��ȿ�� �˻�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		ArrayList<String> idList = new ArrayList<String>(3); //id ���� list
		ArrayList<String> pwdList = new ArrayList<String>(3); //pwd ���� list
		
		int idNum = 0, answer = 0; //id�� ����� ��ȣ�� �α��� ���� ��ȯ ����
		
		try {

			conn = util.open();
			stat = conn.createStatement();
			
			String sql = "select memberid as id, memberpw as pwd from tblmember";
			
			rs = stat.executeQuery(sql);
			
			while (rs.next()) { // ���̺� id,pwd ��������
				
				String result = rs.getString("id") + "\t" + rs.getString("pwd");
				
				idList.add(rs.getString("id"));
				pwdList.add(rs.getString("pwd"));				
			}
			
			for(int i=0; i<idList.size(); i++) {
				if(idList.get(i).equals(id)){ //id ���� ���
					idNum = i;
						
				}else if(!idList.get(i).equals(id)){
					//���� id
					answer = 1;
				}
			}

			if(pwdList.get(idNum).equals(pw)){ //pw ���� ���
				//�α��� ����
				System.out.println("============================================================");
				System.out.printf("�α��� �Ǿ����ϴ�.\n");

				menu();
				return;
				
			} else if (!pwdList.get(idNum).equals(pw)){
				//Ʋ�� pwd
				answer = 2;
			}
			
			//���� �޼��� ���
			if(answer == 1) {
				System.out.println("============================================================");
				System.out.println("���� id�Դϴ�.");
				//�ٽ� �α���
				return;
			}else if(answer == 2) {
				System.out.println("============================================================");
				System.out.println("��й�ȣ�� ���� �ʽ��ϴ�.");
				//�ٽ� �α���
				return;
			}
			
			rs.close();
			stat.close();
			conn.close();
			
			if(menuNum.equals("0")) {
				return;
			}
				


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}//while
	}

	private static void menu() {
		//���� �޴�
		
		boolean flag = true;
		
		while(flag) {
		System.out.println("============================================================");
		System.out.println("\t\t[�޴�]");
		System.out.println("============================================================");
		System.out.println("\t\t 1. ���� ");
		
		System.out.println();
		System.out.println("\t\t0. �α׾ƿ�");
		System.out.println("============================================================");
		
		System.out.print("\t\t�Է� : ");
		String num = scan.nextLine();
		
		switch (num) {

		case "1":
			BusTrain bt = new BusTrain();
			bt.printBusTrain();
			break;
			
		
			
		case "0":
			//�α׾ƿ�
		
			}
		}
		
	}
	
	
	
}