//Author shaishav Maisuria
//December 3 2019

import java.io.*;
import java.net.*;
import java.util.*;
public class EmailSender
{
   public static void main(String[] args) throws Exception
   {
      // Establish a TCP connection with the mail server.
      String name_sender;
      Scanner scan= new Scanner(System.in);
      System.out.print("mail hostname ");
      name_sender=new String();
      name_sender=scan.next();
      
      //asking the user again if nothing is entered in email 
      while(name_sender.isEmpty()) {
    	  System.out.println("Please enter some address");
    	  name_sender=scan.next(); 
      }
      //using socket we try to establish connection on well known smtp port 25
      Socket socket= new Socket(name_sender,25); 
      

      // Create a BufferedReader to read a line at a time.
      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      // Read greeting from the server.
      String response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("220")) {
         throw new Exception("220 reply not received from server.");
      }

      // Get a reference to the socket's output stream.
      OutputStream os = socket.getOutputStream();

      // Send HELO command and get server response.
      String command = "HELO alice\r\n";
      System.out.print(command);
      os.write(command.getBytes("US-ASCII"));
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      // Send MAIL FROM command.
      System.out.println("Enter your e-mail address \n");
      String sourceAddress = scan.next();
      	//we now trying to get the mail from which we want to send data (it could be any random email ID)
      	// foward slash r and fwoard slash n is used to let the server 
      	//know we have done sending our done sending data now check and acknowlege
      String mailFromCommand = "MAIL FROM: <" + sourceAddress + ">\r\n"; 
      System.out.println(mailFromCommand);
      os.write(mailFromCommand.getBytes("US-ASCII")); // converting into format which mail server understands
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("250")) // if no replied is received after sending the data of which contains command
      throw new Exception("250 reply not received from server.\n");
      // Send RCPT TO command.
 String email_address_rcpt= new String();
      
      System.out.print("rcpt to");
      email_address_rcpt= scan.next();
    //we now trying to get the email to which we want to send data (it would be specific email that we established connection with)
      String formatted_command_rcpt= "rcpt to: <"+email_address_rcpt+">\r\n";
      System.out.print(formatted_command_rcpt);
      os.write(formatted_command_rcpt.getBytes("US-ASCII"));
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("250")) {
    	  if(response.startsWith("550")) { // if user write the wrong format of host name of mail server
        	  throw new Exception("550 the host name of mail server is wrong");
          }
    	  else {
         throw new Exception("250 reply not received from server.");
    	  }
      }
      

      // Send DATA command.
      String command_Data = "DATA\r\n";
      System.out.print(command_Data);
      os.write(command_Data.getBytes("US-ASCII"));
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("354")) { // as the data always replies with 354 beginning , so if replied is not received
         throw new Exception("354 reply not received from server.");
      }
      	//asking user in email format " From "
      System.out.print("From:");
      Scanner scan3= new Scanner(System.in);
      String from= scan3.nextLine();
      String command_from= "FROM:"+from+"\n"; // not using /r as we are still want to send more data
      System.out.print(command_from);
      os.write(command_from.getBytes("US-ASCII"));
  
    //asking user in email format " To "
      System.out.print("To:");
      String to= scan3.nextLine();
      String command_to= "TO:"+to+"\n";
      System.out.print(command_to);
      os.write(command_to.getBytes("US-ASCII"));
     
    //asking user in email format " Subject "
      
      System.out.print("Subject:");
      String Subject= scan3.nextLine();
      String command_Subject= "SUBJECT:"+Subject+"\r\n";
      System.out.print(command_Subject);
      os.write(command_Subject.getBytes("US-ASCII"));
     
      
      // Send message data.
      String message= new String();
      Scanner scan2= new Scanner(System.in);
      System.out.print("message you want to send");
      message= scan2.nextLine();
      String command_msg= "\n"+message+"\r\n";  
      
      // when at the end of data sending period
      os.write(command_msg.getBytes("US-ASCII"));
      String single_period= "."+"\r\n";
      System.out.print("single period");
      System.out.print(single_period);
      os.write(single_period.getBytes("US-ASCII"));
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("250")) {
         throw new Exception("250 reply not received from server.");
      }

      // Send QUIT command.
      String command_quit = "QUIT\r\n";
      System.out.print(command_quit);
      os.write(command_quit.getBytes("US-ASCII"));
      response = br.readLine();
      System.out.println(response);
      if (!response.startsWith("221")) {
         throw new Exception("221 reply not received from server. for closing the connection");
      }
      
      
      //closing the connection using socket completely
      socket.close();
   }
}
 