package main;

<<<<<<< HEAD
=======
 

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
<<<<<<< HEAD

public class BusTrain {
	
	
		
=======
 
public class BusTrain {
		

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
		private static Connection conn = null;
		private static Statement stat = null;
		private static ResultSet rs = null;
		private static DBUtil util = new DBUtil();
		private static Scanner scan = new Scanner(System.in);
		
<<<<<<< HEAD
		public void printBusTrain() {
			
			boolean loop = true;
			
			
			while (loop) { // 
=======

		public void printBusTrain() {		

			boolean loop = true;		

			

			while (loop) { //

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
				System.out.println("============================================================");
				System.out.println("		[������� ����]");
				System.out.println("============================================================");
				System.out.println("1 : 		[���� ����]");
				System.out.println("2 : 		[���� ����]");
				
				Connection conn = null;
				Statement stat = null;
				ResultSet rs = null;
<<<<<<< HEAD
				
				System.out.println("---------------------------------------------------------");
				System.out.print("�Է� : ");
				String sel = scan.nextLine();
				
				if (sel.equals("1")) {
				try {
=======

				

				System.out.println("---------------------------------------------------------");
				System.out.print("�Է� : ");

				String sel = scan.nextLine();

				

				if (sel.equals("1")) {

				try {

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
					conn = util.open();
					stat = conn.createStatement();
					
					String sql = "select trainstation_seq as ����ȣ, trainstationname as ���̸� from tbltrainstation order by trainstation_seq";
<<<<<<< HEAD
					
					rs = stat.executeQuery(sql);
					System.out.println("================================================================================================================================");
//					System.out.println("[������ȣ]\t\t\t\t[������]\t\t\t\t[�����Ⱓ]\t\t[�����]\t[���ǽ�]");
					while (rs.next()) { //����ȣ, ���̸�  ��߱���
						
						String result = String.format("%s\t%s",rs.getString("����ȣ"),rs.getString("���̸�"));				


						
						System.out.println(result);
						
					}
					System.out.println("================================================================================================================================");
					
					System.out.print("��� ������ : ");
					String starttrain = scan.nextLine();
					
					System.out.println();
					System.out.println();
					conn.close();
					stat.close();
					
					
						try {
							conn = util.open();
							stat = conn.createStatement();
							rs = null;
							
							String sql2 = "select trainstation_seq as ����ȣ, trainstationname as ���̸� from tbltrainstation order by trainstation_seq";
													
							rs = stat.executeQuery(sql2);
							System.out.println("================================================================================================================================");
//							System.out.println("[������ȣ]\t\t\t\t[������]\t\t\t\t[�����Ⱓ]\t\t[�����]\t[���ǽ�]");
							while (rs.next()) { //����ȣ, ���̸�  ��������
								
								String result = String.format("%s\t%s",rs.getString("����ȣ"),rs.getString("���̸�"));				


								
								System.out.println(result);							
								
							}
							System.out.println("========================================================================================================================");
							System.out.print("���� ��������ȣ : ");
							String arrivetrain = scan.nextLine();
							
=======

					

					rs = stat.executeQuery(sql);
					System.out.println("================================================================================================================================");
//					System.out.println("[������ȣ]\t\t\t\t[������]\t\t\t\t[�����Ⱓ]\t\t[�����]\t[���ǽ�]");

					while (rs.next()) { //����ȣ, ���̸�  ��߱���						

						String result = String.format("%s\t%s",rs.getString("����ȣ"),rs.getString("���̸�"));	

						System.out.println(result);

					}

					System.out.println("================================================================================================================================");

					System.out.print("��� ������ : ");
					String starttrain = scan.nextLine();

					System.out.println();
					System.out.println();
					conn.close();
					stat.close();	

						try {

							conn = util.open();
							stat = conn.createStatement();
							rs = null;							

							String sql2 = "select trainstation_seq as ����ȣ, trainstationname as ���̸� from tbltrainstation order by trainstation_seq";
													

							rs = stat.executeQuery(sql2);
							System.out.println("================================================================================================================================");

//							System.out.println("[������ȣ]\t\t\t\t[������]\t\t\t\t[�����Ⱓ]\t\t[�����]\t[���ǽ�]");

							while (rs.next()) { //����ȣ, ���̸�  ��������

								

								String result = String.format("%s\t%s",rs.getString("����ȣ"),rs.getString("���̸�"));
								System.out.println(result);							

							}

							System.out.println("========================================================================================================================");
							System.out.print("���� ��������ȣ : ");

							String arrivetrain = scan.nextLine();							

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
							System.out.println("����ȭ");
							System.out.println("KTX");
							System.out.println("ITX-������");
							System.out.print("���� ���� : ");
							String traintype = scan.nextLine();
<<<<<<< HEAD
							
							
							System.out.println();
							System.out.println();
//							rs.close();							
							conn.close();
							stat.close();							
							
							
							try {
								conn = util.open();
								stat = conn.createStatement();
								rs = null;
//								System.out.println("�־ȴ�");
//								String sql3 = "select distinct traintype as ��������, e.* ," + 
//										"to_char(trainstart_time,'hh24:mi') as ��߽ð�, d.trainstationname as ���������� ," + 
//										"    to_char(trainarrive_time,'hh24:mi') as �����ð�,trainprice as ����, trans_seq as ������ȣ" + 
//										"        from" + 
//										"        (select  b.trainstationname as ��߱����� " + 
//										"        from tbltrain a" + 
//										"            inner join tbltrainstation b" + 
//										"                on a.Strainstation_seq = b.trainstation_seq" + 
//										"                     where traintype = '����ȭ' and a.Strainstation_seq = 1 and a.Atrainstation_seq = 15) e," + 
//										"                     tbltrain c" + 
//										"            inner join tbltrainstation d" + 
//										"                on c.Atrainstation_seq = d.trainstation_seq" + 
//										"                     where traintype = '����ȭ' and c.Strainstation_seq = 1 and c.Atrainstation_seq = 15" + 
//										"                     order by c.trans_seq";
								
=======

							System.out.println();
							System.out.println();

//							rs.close();							

							conn.close();
							stat.close();							

							try {

								conn = util.open();
								stat = conn.createStatement();
								rs = null;

//								System.out.println("�־ȴ�");
//								String sql3 = "select distinct traintype as ��������, e.* ," + 
//										"to_char(trainstart_time,'hh24:mi') as ��߽ð�, d.trainstationname as ���������� ," +
//										"    to_char(trainarrive_time,'hh24:mi') as �����ð�,trainprice as ����, trans_seq as ������ȣ" +
//										"        from" + 
//										"        (select  b.trainstationname as ��߱����� " +
//										"        from tbltrain a" +
//										"            inner join tbltrainstation b" +
//										"                on a.Strainstation_seq = b.trainstation_seq" +
//										"                     where traintype = '����ȭ' and a.Strainstation_seq = 1 and a.Atrainstation_seq = 15) e," +
//										"                     tbltrain c" + 
//										"            inner join tbltrainstation d" +
//										"                on c.Atrainstation_seq = d.trainstation_seq" +
//										"                     where traintype = '����ȭ' and c.Strainstation_seq = 1 and c.Atrainstation_seq = 15" +
//										"                     order by c.trans_seq";								

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
								String sql3 = String.format("select distinct traintype as ��������, e.* ," + 
										"to_char(trainstart_time,'hh24:mi') as ��߽ð�, d.trainstationname as ���������� ," + 
										"    to_char(trainarrive_time,'hh24:mi') as �����ð�,trainprice as ����, trans_seq as ������ȣ" + 
										"        from" + 
										"        (select  b.trainstationname as ��߱����� " + 
										"        from tbltrain a" + 
										"            inner join tbltrainstation b" + 
										"                on a.Strainstation_seq = b.trainstation_seq" + 
<<<<<<< HEAD
										"                     where traintype = '%s' and a.Strainstation_seq = %s and a.Atrainstation_seq = %S) e," + 
										"                     tbltrain c" + 
										"            inner join tbltrainstation d" + 
										"                on c.Atrainstation_seq = d.trainstation_seq" + 
										"                     where traintype = '%S' and c.Strainstation_seq = %S and c.Atrainstation_seq = %S" + 
										"                     order by c.trans_seq", traintype, starttrain,arrivetrain,traintype,starttrain,arrivetrain);


														
=======
										"                     where traintype = '%s' and a.Strainstation_seq = %s and a.Atrainstation_seq = %S) e," +
										"                     tbltrain c" + 
										"            inner join tbltrainstation d" +
										"                on c.Atrainstation_seq = d.trainstation_seq" +
										"                     where traintype = '%S' and c.Strainstation_seq = %S and c.Atrainstation_seq = %S" +
										"                     order by c.trans_seq", traintype, starttrain,arrivetrain,traintype,starttrain,arrivetrain);

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
								rs = stat.executeQuery(sql3);
								System.out.println("================================================================================================================================");
								System.out.println("[��������]\t[��߱�����]\t[��߽ð�]\t[����������]\t[�����ð�]\t[����]\t[������ȣ]");
								while (rs.next()) { //����ȣ, ���̸�  ��������
<<<<<<< HEAD
									
									String result = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s",rs.getString("��������"),rs.getString("��߱�����"),rs.getString("��߽ð�"),rs.getString("����������"),rs.getString("�����ð�"),rs.getString("����"),rs.getString("������ȣ"));				

									
									
									System.out.println(result);				
							}
								System.out.println("========================================================================================================================");
								System.out.print("�����ϱ� : ");
=======

									

									String result = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s",rs.getString("��������"),rs.getString("��߱�����"),rs.getString("��߽ð�"),rs.getString("����������"),rs.getString("�����ð�"),rs.getString("����"),rs.getString("������ȣ"));				

									System.out.println(result);				

							}

								System.out.println("========================================================================================================================");
								System.out.print("�����ϱ� : ");

>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
								String trainreserv = scan.nextLine();
								rs.close();							
								conn.close();
								stat.close();
<<<<<<< HEAD
							}
								catch (Exception e) {
								// TODO: handle exception
							}
							
							
//							loop = false;
							
							System.out.println();
							System.out.print("����Ͻ÷��� ���͸� �����ּ���");						
							String num3 = scan.nextLine();
						} catch (Exception e) {
							e.printStackTrace();
							// TODO: handle exception
						}
						
			
					
					
					conn.close();
					stat.close();
					
					loop = false;
				} catch (Exception e) {
					e.printStackTrace();
				}
				} else if (sel.equals("2")) {
					
					System.out.println("---------------------------------------------------------");
					System.out.println("1 : 		[1 ���ǽ�]");
					System.out.println("2 : 		[2 ���ǽ�]");
					System.out.println("3 : 		[3 ���ǽ�]");
					System.out.println("4 : 		[4 ���ǽ�]");
					System.out.println("5 : 		[5 ���ǽ�]");
					System.out.println("6 : 		[6 ���ǽ�]");
					System.out.println("---------------------------------------------------------");
					System.out.print("��������ȸ���ǽ� : ");
					String num2 = scan.nextLine();
					
					try {
						conn = util.open();
						stat = conn.createStatement();
						rs = null;
						
						String sql = String.format("SELECT ti.item_seq as �������ȣ, ti.name as �������, ti.itemqty as ���������, ti.room_seq as ���ǽ�" + 
								"    FROM tblItem ti" + 
								"        INNER JOIN tblroom tr" + 
								"            ON tr.room_seq = ti.room_seq" + 
								"                INNER JOIN tblCourselist cl" + 
								"                    ON cl.Courselist_seq = ti.Courselist_seq" + 
								"                        WHERE ti.room_seq = %s ", num2);
												
						rs = stat.executeQuery(sql);
						System.out.println("============================================================");
						System.out.println("[�������ȣ]\t[�������]\t[���������]\t[���ǽ�]");
						while (rs.next()) { //�������ȣ, �������, ���������, ���ǽ�
							
//							String result = String.format("%5s\t\t%6s\t%6s\t\t%5s", rs.getString("�������ȣ"),  rs.getString("�������"), rs.getString("���������")
//							,rs.getString("���ǽ�"));
							String result = String.format("%-5s\t\t%-6s\t%-6s\t\t%-5s", rs.getString("�������ȣ"),  rs.getString("�������"), rs.getString("���������")
							,rs.getString("���ǽ�"));
					
							System.out.println(result);
								
						}
						System.out.println("============================================================");
						rs.close();							
						conn.close();
						stat.close();
						
						
						loop = false;
						
						System.out.println();
						System.out.print("����Ͻ÷��� ���͸� �����ּ���");						
						String num3 = scan.nextLine();
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
					
				}
					
					
			}//while
			
			
			
		}

}

=======

							}

								catch (Exception e) {

								// TODO: handle exception

							}

							

							

//							loop = false;

							

							System.out.println();

							System.out.print("����Ͻ÷��� ���͸� �����ּ���");						

							String num3 = scan.nextLine();

						} catch (Exception e) {

							e.printStackTrace();

							// TODO: handle exception

						}

						

			

					

					

					conn.close();

					stat.close();

					

					loop = false;

				} catch (Exception e) {

					e.printStackTrace();

				}

				} else if (sel.equals("2")) {

					

					System.out.println("---------------------------------------------------------");

					System.out.println("1 : 		[1 ���ǽ�]");

					System.out.println("2 : 		[2 ���ǽ�]");

					System.out.println("3 : 		[3 ���ǽ�]");

					System.out.println("4 : 		[4 ���ǽ�]");

					System.out.println("5 : 		[5 ���ǽ�]");

					System.out.println("6 : 		[6 ���ǽ�]");

					System.out.println("---------------------------------------------------------");

					System.out.print("��������ȸ���ǽ� : ");

					String num2 = scan.nextLine();

					

					try {

						conn = util.open();

						stat = conn.createStatement();

						rs = null;

						

						String sql = String.format("SELECT ti.item_seq as �������ȣ, ti.name as �������, ti.itemqty as ���������, ti.room_seq as ���ǽ�" + 

								"    FROM tblItem ti" + 

								"        INNER JOIN tblroom tr" + 

								"            ON tr.room_seq = ti.room_seq" + 

								"                INNER JOIN tblCourselist cl" + 

								"                    ON cl.Courselist_seq = ti.Courselist_seq" + 

								"                        WHERE ti.room_seq = %s ", num2);

												

						rs = stat.executeQuery(sql);

						System.out.println("============================================================");

						System.out.println("[�������ȣ]\t[�������]\t[���������]\t[���ǽ�]");

						while (rs.next()) { //�������ȣ, �������, ���������, ���ǽ�

							

//							String result = String.format("%5s\t\t%6s\t%6s\t\t%5s", rs.getString("�������ȣ"),  rs.getString("�������"), rs.getString("���������")

//							,rs.getString("���ǽ�"));

							String result = String.format("%-5s\t\t%-6s\t%-6s\t\t%-5s", rs.getString("�������ȣ"),  rs.getString("�������"), rs.getString("���������")

							,rs.getString("���ǽ�"));

					

							System.out.println(result);

								

						}

						System.out.println("============================================================");

						rs.close();							

						conn.close();

						stat.close();

						

						

						loop = false;

						

						System.out.println();

						System.out.print("����Ͻ÷��� ���͸� �����ּ���");						

						String num3 = scan.nextLine();

					} catch (Exception e) {

						e.printStackTrace();

						// TODO: handle exception

					}

					

					

				}

					

					

			}//while

			

			

			

		}

 

}
>>>>>>> 893ca2aff8565f9b0373ae9c50c0aa462e0b5b92
