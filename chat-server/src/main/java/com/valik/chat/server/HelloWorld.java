//*************************************************//
//          INTHER LOGISTICS ENGINEERING           //
//*************************************************//
package com.valik.chat.server;

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
	String name = rqst.body();
	return "Hello, " + name;
      }
    });

  }
}
