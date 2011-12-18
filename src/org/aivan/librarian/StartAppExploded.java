package org.aivan.librarian;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartAppExploded
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
 
        WebAppContext context = new WebAppContext();
        context.setDescriptor("resources/WEB-INF/web.xml");
        context.setResourceBase("resources/");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
 
        server.start();
        server.join();
    }
}