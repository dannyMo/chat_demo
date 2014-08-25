//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.test;

import com.valik.chat.converter.Converter;
import com.valik.chat.data.ChatMessage;
import com.valik.chat.data.MessageLog;
import com.valik.chat.data.User;

/**
 *
 * @since Aug 23, 2014
 * @author dmorari
 */
public class MainTest
{

  public static void main(String[] args)
  {
    MessageLog messageLog = new MessageLog();

    User user1 = new User();
    user1.setName("Jimmy");
    user1.setLastname("Pop");

    User user2 = new User();
    user2.setName("Alex");
    user2.setLastname("Balls");

    ChatMessage chatMessage1 = new ChatMessage();
    chatMessage1.setAuthor(user1);
    chatMessage1.setMessage("Hello Alex. How are you!");

    ChatMessage chatMessage2 = new ChatMessage();
    chatMessage2.setAuthor(user2);
    chatMessage2.setMessage("Hi Jimmy! I'm quite ok, how is your dog?");

    ChatMessage chatMessage3 = new ChatMessage();
    chatMessage3.setAuthor(user1);
    chatMessage3.setMessage("My dog is ok, may be even better than everything");

    messageLog.addMessage(chatMessage1);
    messageLog.addMessage(chatMessage2);
    messageLog.addMessage(chatMessage3);

    // Convert to XML
    String msg = Converter.getInstance().toXML(messageLog);

    System.out.println(msg);
  }
}
