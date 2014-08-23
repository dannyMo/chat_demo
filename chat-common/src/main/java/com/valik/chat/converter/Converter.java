//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.chat.converter;

import com.valik.chat.data.MessageLog;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @since Aug 23, 2014
 * @author dmorari
 */
public class Converter
{

  private Converter()
  {
  }

  private static final Converter self = new Converter();

  public static Converter getInstance()
  {
    return self;
  }

  public String toXML(MessageLog messageFeed)
  {
    try
    {
      JAXBContext jAXBContext = JAXBContext.newInstance(MessageLog.class);
      Marshaller marshaller = jAXBContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      StringWriter stringWriter = new StringWriter();
      marshaller.marshal(messageFeed, stringWriter);

      return stringWriter.toString();
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }

  public MessageLog toMessageFeed(String xmlString)
  {
    try
    {

      JAXBContext jAXBContext = JAXBContext.newInstance(MessageLog.class);
      Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
      StringReader stringReader = new StringReader(xmlString);
      return (MessageLog) unmarshaller.unmarshal(stringReader);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
}
