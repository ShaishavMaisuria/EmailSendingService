# EmailSendingService
This project was done for class course, This code is only for display to recruiters. Please dont copy or use my code or any of the material from my repository without my written permision.  
I have protected my code with right full rights please refer to license section.
Where my files are protected under Apache License 2.0 and Honor code of My college.

# Project EMail-service: Without GUI .

## Sending Email with Telnet:
•	In this project I tried sending email to myself. In order to do that One need to know host name of mail server for my mail domain depending on mail service. In order to find out this information I preformed DNS query for MX record that registers the information about my mail domain. For email: xyz@imailt.com

•	I have used following mail service in order to perform entire project. Mail service= https://temp-mail.org/en/. Also, after performing query I got the following host name of mail server which need to be used as the very first input in java code later. example  mail.imailt.top

•	Next step is to establish a TCP connection with the mail server using smtp port number. I have used well know port for smtp which is port 25 both in part 1 and part 2

•	Using telnet, I enter the required commands that used to send the email. Such as, to check whether port is listening or not and we are receiving any response we use any string example hello allice. Then, Email ID from which we want to send email as (we can use any email address or create a random one with @ and “.”format in it). Then, RCPT TO command was used, In this we need to write the email ID we used to send the email (in this case our mail sever email which is xyz@imailt.com). Then, we send DATA command and data we want to send which can consists of Subject, to, from, message. Once that is done, ”.” is used to notify the server that the end of data. We close the connection by QUIT command.

## Sending email with CODE (JAVA).

•	I have wrote a Java program that establishes TCP connection with mail server through socket interface, and sends email message using the same port for part 1 which is port 25. I also had to check whether port is listening or not and we are receiving any response depending the command we sending to mail server.

•	Also, each line of string entered cannot be read by the mail server in string format, I had to understand that I have to send all my data encoded in array of bytes in ASCII format. I understood that once we send this encoded data depending on command we may or may not get response. In addition, in order to indicate that we are done sending our specific command or data and wants the mail server to process. we need to inidicate using “\r\n”

•	Main thing I had to understand which commands will receive a response and which will not. This acknowledgments are seen in most of commands except after DATA to “.” Command. The reason is a DATA command does gets response back and then onwards as everything is considered as single message (until we write “\r\n” which is end of the data). Data can have formats of subject, To, form, message

•	The only condition for the part 2 is the format of what should be host name server should be know before hand in java code. I have taken host name from part 1 which is mail.imailt.top . All the commands and steps discussed in part 1 at very end is same and exact to how I have wrote the code. Which means we enter same input that we enter in part 1 and observe same output in both part 1 and 2

•	As, using the socket interface I had to open socket for establish connection and close at very end of the program. Part 1 and part 2 functions similar and gives the same output. 


----------------------------------------------------------- End of Report-------------------------------------------------------------------------






## Extra information in regards to file:
•	JAVA file
o	EmailSender.java = Java code for email sending

•	Cmd screenshots folder consists of
o	Before_cmd.png= the screen shot of before sending anything from cmd
o	Part1_cmd= is the screen shot of whether email is received or not which was sent from cmd
o	Part2_cmd = is the screens shot of what is inside email that is sent from cmd

•	JAVA code input output screenshots folder consists of
o	Javacode_part1= the screen shot of before sending anything from java code
o	Javacode_output_part1= is the screen shot of whether email is received or not which was sent from java code
o	Javacode_output_part2= is the screens shot of what is inside email that is sent from java code

•	Report file
o	Network project report= consists of key application and understandings and outcomes

•	Lin file
o 

## prerequisite
o Java 

o Network Understanding

o Linux Environment




