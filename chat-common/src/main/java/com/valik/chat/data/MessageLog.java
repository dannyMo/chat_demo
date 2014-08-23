//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.chat.data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @since Aug 23, 2014
 * @author dmorari
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MessageLog
{

  @XmlElement(name = "message")
  private List<ChatMessage> messages = new ArrayList<>();

  public List<ChatMessage> getMessages()
  {
    return messages;
  }

  public void setMessages(List<ChatMessage> messages)
  {
    this.messages = messages;
  }

  public void addMessage(ChatMessage msg)
  {
    this.messages.add(msg);
  }
}
