package org.aivan.librarian;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartAppAsWar
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
 
        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar("dist/war/librarian.war");
        server.setHandler(webapp);
 
        server.start();
        server.join();
    }
}