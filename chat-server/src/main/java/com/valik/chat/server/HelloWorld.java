//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.chat.server;

import com.valik.chat.converter.Converter;
import com.valik.chat.data.ChatMessage;
import com.valik.chat.data.MessageLog;
import com.valik.chat.data.User;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;

public class HelloWorld
{

  public static void main(String[] args)
  {
    setPort(8080);
    post("/hello", new Route()
    {

      @Override
      public Object handle(Request rqst, Response rspns)
      {
	String userData = rqst.body();
        String[] userDataArray = userData.split(";");
        
        User user = new User();
        user.setName(userDataArray[0]);
        user.setLastname(userDataArray[1]);
        
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setAuthor(user);
        chatMessage.setMessage(userDataArray[2]);
        
        MessageLog messageLog = new MessageLog();
        messageLog.addMessage(chatMessage);

        // Convert to XML
        String msg = Converter.getInstance().toXML(messageLog);
          System.out.println("" + msg);
	return msg;
      }
    });

  }
}
