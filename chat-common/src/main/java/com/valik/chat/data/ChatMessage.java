//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.chat.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @since Aug 23, 2014
 * @author dmorari
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ChatMessage
{

  @XmlElement(name = "user")
  private User author;

  @XmlElement(name = "message")
  private String message;

  @XmlAttribute(name = "timestamp")
  private long timestamp = System.currentTimeMillis();

  public User getAuthor()
  {
    return author;
  }

  public void setAuthor(User author)
  {
    this.author = author;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }

  public long getTimestamp()
  {
    return timestamp;
  }

  public void setTimestamp(long timestamp)
  {
    this.timestamp = timestamp;
  }

}
