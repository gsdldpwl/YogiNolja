package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BusTrain {
   
   
      
      private static Connection conn = null;
      private static Statement stat = null;
      private static ResultSet rs = null;
      private static ResultSet rs2 = null;
      private static DBUtil util = new DBUtil();
      private static Scanner scan = new Scanner(System.in);
      
      public void printBusTrain() {
         
         boolean loop = true;
         
         
         while (loop) { // 
            System.out.println("============================================================");
            System.out.println("      [������� ����]");
            System.out.println("============================================================");
            System.out.println("1 :       [���� ����]");
            System.out.println("2 :       [���� ����]");
            System.out.println("3 :       [���� Ȯ��]");
            
            Connection conn = null;
            Statement stat = null;
            ResultSet rs = null;
            
            System.out.println("---------------------------------------------------------");
            System.out.print("�Է� : ");
            String sel = scan.nextLine();
            
            if (sel.equals("1")) {               
               System.out.print("��¥(MM-DD����) : ");
               String date= scan.nextLine();
            try {
               conn = util.open();
               stat = conn.createStatement();
               
               String sql = "select trainstation_seq as ����ȣ, trainstationname as ���̸� from tbltrainstation order by trainstation_seq";
               
               rs = stat.executeQuery(sql);
               System.out.println("================================================================================================================================");
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
//                     System.out.println("[������ȣ]\t\t\t\t[������]\t\t\t\t[�����Ⱓ]\t\t[�����]\t[���ǽ�]");
                     while (rs.next()) { //����ȣ, ���̸�  ��������
                        
                        String result = String.format("%s\t%s",rs.getString("����ȣ"),rs.getString("���̸�"));            


                        
                        System.out.println(result);                     
                        
                     }
                     System.out.println("========================================================================================================================");
                     System.out.print("���� ��������ȣ : ");
                     String arrivetrain = scan.nextLine();
                     
                     System.out.println("����ȭ");
                     System.out.println("KTX");
                     System.out.println("ITX-������");
                     System.out.print("���� ���� : ");
                     String traintype = scan.nextLine();
                     
                     
                     System.out.println();
                     System.out.println();
//                     rs.close();                     
                     conn.close();
                     stat.close();                     
                     
                     
                     try {
                        conn = util.open();
                        stat = conn.createStatement();
                        rs = null;
                        
                        String sql3 = String.format("select distinct traintype as ��������, e.* ," + 
                              "to_char(trainstart_time,'hh24:mi') as ��߽ð�, d.trainstationname as ���������� ," + 
                              "    to_char(trainarrive_time,'hh24:mi') as �����ð�,trainprice as ����, c.train_seq as ������ȣ" + 
                              "        from" + 
                              "        (select  b.trainstationname as ��߱����� " + 
                              "        from tbltrain a" + 
                              "            inner join tbltrainstation b" + 
                              "                on a.Strainstation_seq = b.trainstation_seq" + 
                              "                     where traintype = '%s' and a.Strainstation_seq = %s and a.Atrainstation_seq = %S) e," + 
                              "                     tbltrain c" + 
                              "            inner join tbltrainstation d" + 
                              "                on c.Atrainstation_seq = d.trainstation_seq" + 
                              "                     where traintype = '%S' and c.Strainstation_seq = %S and c.Atrainstation_seq = %S" + 
                              "                     order by c.train_seq", traintype, starttrain,arrivetrain,traintype,starttrain,arrivetrain);


                                          
                        rs = stat.executeQuery(sql3);
                        System.out.println("================================================================================================================================");
                        System.out.println("[������ȣ]\t[��������]\t[��߱�����]\t[��߽ð�]\t[����������]\t[�����ð�]\t[����]");
                        while (rs.next()) { //����ȣ, ���̸�  ��������
                           
                           String result = String.format("%s\t%s\t%s\t%s\t%s\t%s\t%s", rs.getString("������ȣ"),rs.getString("��������"),rs.getString("��߱�����"),rs.getString("��߽ð�"),rs.getString("����������"),rs.getString("�����ð�"),rs.getString("����"));            

                           
                           
                           System.out.println(result);            
                     }
                        System.out.println("========================================================================================================================");
                        System.out.println("1. �����ϱ�");
                        System.out.println("2. �ڷΰ���");
                        System.out.println("========================================================================================================================");
                        System.out.print("��ȣ �Է� : ");
                        String num = scan.nextLine();
                        switch (num) {

                        case "1":
                           System.out.print("������ȣ : ");
                           String trainreserv = scan.nextLine();
                           System.out.print("�ο� : ");
                           String count = scan.nextLine();
                           try {
                              conn = util.open();
                              stat = conn.createStatement();
                              rs = null;
                              
                              
                              String sql13 =  String.format("select trainprice from tbltrain where train_seq = %s",trainreserv);
                              rs = stat.executeQuery(sql13);
                              if ( rs.next()) {
                                 String result = String.format("%s", rs.getString("trainprice"));
//                                 String result = String.format("%s", "trainprice");
                                 System.out.println(Integer.parseInt(result) * Integer.parseInt(count));   
                              }
                              
                              System.out.println("������ �����Ͻðڽ��ϱ�?");
                              System.out.println("������ �����մϴ�!!!");
                              System.out.print("��й�ȣ�� �Է����ּ��� :");
                              String credit = scan.nextLine();
                              
                              try {
                                 conn = util.open();
                                 stat = conn.createStatement();
                                 rs = null;
                                 
                                 
                                 String sql14 =  String.format("select member_seq from tblmember where memberpw = '%s'",credit);
                                 rs = stat.executeQuery(sql14);
                                 if ( rs.next()) {
                                    String result = String.format("%s", rs.getString("member_seq"));                                 
                                    String sql9 = String.format("insert into tbltransreserv values (transreserv_seq.nextval,to_date('%s', 'MM-DD'),%s,%s,null,%s)", date, count,trainreserv, result );
                                    stat.executeUpdate(sql9);
                                 }
                              } catch (Exception e) {
                                 // TODO: handle exception
                              }
                              
                              
                              
                           } catch (Exception e) {
                              e.printStackTrace();
                              // TODO: handle exception
                           }
                           
                           
                           
                           
                           
                           rs.close();                     
                           conn.close();
                           stat.close();
                           
                        
                           
                        case "0":
                           //�α׾ƿ�
                           rs.close();   
                           conn.close();
                           stat.close();
                           
                           loop = false;
                           }
                        
                     }
                        catch (Exception e) {
                        // TODO: handle exception
                     }
                     
                     
//                     loop = false;
                     
                     System.out.println();
                     System.out.println("���� �Ϸ�!");
                     System.out.print("����Ͻ÷��� ���͸� �����ּ���");   
                     System.out.println();
                     
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
            
            
            //���� ����
            } else if (sel.equals("2")) {
               System.out.print("��¥(MM-DD����) : ");
               String date2= scan.nextLine();
               try {
                  conn = util.open();
                  stat = conn.createStatement();
                  
                  String sql4 = "select busstation_seq as �͹̳ι�ȣ, busstationloca as ����, busstationname as �͹̳θ� from tblbusstation";
                  
                  rs = stat.executeQuery(sql4);
                  System.out.println("================================================================================================================================");
                  while (rs.next()) { //����ȣ, ����, �͹̳��̸�
                     
                     String result = String.format("%s\t%s",rs.getString("�͹̳ι�ȣ"),rs.getString("����"),rs.getString("�͹̳θ�"));            


                     
                     System.out.println(result);
                  }
                  System.out.println("================================================================================================================================");
                  
                  System.out.print("��� �����͹̳� : ");
                  String startbus = scan.nextLine();
                  
                  System.out.println();
                  System.out.println();
                  conn.close();
                  stat.close();
                  
                  try {
                     conn = util.open();
                     stat = conn.createStatement();
                     
                     String sql5 = "select busstation_seq as �͹̳ι�ȣ, busstationloca as ����, busstationname as �͹̳θ� from tblbusstation";
                     
                     rs = stat.executeQuery(sql5);
                     System.out.println("================================================================================================================================");
                     while (rs.next()) { //����ȣ, ����, �͹̳��̸�
                        
                        String result = String.format("%s\t%s",rs.getString("�͹̳ι�ȣ"),rs.getString("����"),rs.getString("�͹̳θ�"));            


                        
                        System.out.println(result);
                     }
                     System.out.println("========================================================================================================================");
                     System.out.print("���� �����͹̳ι�ȣ : ");
                     String arrivebus = scan.nextLine();                     
                     System.out.println();
                     System.out.println();
//                     rs.close();                     
                     conn.close();
                     stat.close();      
                     
                     try {
                        conn = util.open();
                        stat = conn.createStatement();
                        rs = null;
                        
                        String sql6 = String.format("select DISTINCT bus_seq " + 
                              "    as ������ȣ ,d.busstationloca as �����, to_char(busstarttime,'hh24:mi') as ��߽ð�,bustime as �ҿ�ð�,  e.*,  busprice as ���� " + 
                              "        from (select DISTINCT b.busstationloca as ������     "+ 
                              "        from tblbus a" + 
                              "        inner join tblbusstation b" + 
                              "            on a.abusstation_seq2 = b.busstation_seq" + 
                              "            where a.sbusstation_seq = %s and a.abusstation_seq2 = %s) e," + 
                              "        tblbus c "+ 
                              "        inner join tblbusstation d" + 
                              "            on c.sbusstation_seq = d.busstation_seq" + 
                              "             where c.sbusstation_seq = %s and c.abusstation_seq2 = %s" + 
                              "                order by c.bus_seq", startbus,arrivebus,startbus,arrivebus );


                                          
                        rs = stat.executeQuery(sql6);
                        System.out.println("================================================================================================================================");
                        System.out.println("[������ȣ]\t[�����]\t[��߽ð�]\t[�ҿ�ð�]\t[������]\t[����]");
                        while (rs.next()) { //����ȣ, ���̸�  ��������
                           
                           String result = String.format("%s\t%s\t%s\t%s\t%s\t%s",rs.getString("������ȣ"),rs.getString("�����"),rs.getString("��߽ð�"),rs.getString("�ҿ�ð�"),rs.getString("������"),rs.getString("����"));            

                           
                           
                           System.out.println(result);      
                        }
                        System.out.println("========================================================================================================================");
                        System.out.println("1. �����ϱ�");
                        System.out.println("0. �ڷΰ���");
                        System.out.println("========================================================================================================================");
                        
                        System.out.print("��ȣ �Է� : ");
                        String num2 = scan.nextLine();
                        
                        switch(num2) {
                        //�����ϱ�
                        case "1":
                           System.out.print("������ȣ : ");
                           String busreserv = scan.nextLine();
                           System.out.print("�ο� : ");
                           String count2 = scan.nextLine();
                           
                           String price = String.format("select busprice from tblbus where bus_seq = %s", busreserv);
                           rs = stat.executeQuery(price);                           
                           if ( rs.next()) {
                              String result = String.format("%s", rs.getString("busprice"));

                              System.out.println(Integer.parseInt(result) * Integer.parseInt(count2));   
                           }
                           
                           System.out.println("������ �����Ͻðڽ��ϱ�?");
                           System.out.println("������ �����մϴ�!!!");
                           System.out.print("��й�ȣ�� �Է����ּ��� :");
                           String credit = scan.nextLine();
                           try {
                              conn = util.open();
                              stat = conn.createStatement();
                              rs = null;
                              
                              
                              String sql15 =  String.format("select member_seq from tblmember where memberpw = '%s'",credit);
                              rs = stat.executeQuery(sql15);
                              if ( rs.next()) {
                                 String result = String.format("%s", rs.getString("member_seq"));                                 
                                 String sql18 = String.format("insert into tbltransreserv values (transreserv_seq.nextval,to_date('%s', 'MM-DD'),%s,null,%s,%s)", date2, count2,busreserv, result );
                                 stat.executeUpdate(sql18);
                              }
                           } catch (Exception e) {
                              // TODO: handle exception
                           }
                           
//                           String sql10 = String.format("insert into tbltransreserv values (transreserv_seq.nextval,to_date('%s', 'MM-DD'),%s,%s,null,1)", date2 , count2, busreserv );
                           
                           
                           
                           
                           rs.close();                     
                           conn.close();
                           stat.close();
                           System.out.println();
                           System.out.println("���� �Ϸ�!");
                           System.out.print("����Ͻ÷��� ���͸� �����ּ���");
                           System.out.println();
                        //�ڷΰ���
                        case "0":
                        }
                        
                        
                        
                     } catch (Exception e) {
                        // TODO: handle exception
                     }
                     
                  } catch (Exception e) {
                     // TODO: handle exception
                  }
               } catch (Exception e) {
                  e.printStackTrace();
                  // TODO: handle exception
               }
               
               
            } 
            //����Ȯ��
            else if(sel.equals("3")) {
               System.out.print("��й�ȣ�� �Է����ּ��� :");
               String credit = scan.nextLine();
               
            }
               
               
         }//while
         
         
         
      }

}
