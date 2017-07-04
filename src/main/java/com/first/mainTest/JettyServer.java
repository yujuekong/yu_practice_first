package com.first.mainTest;

import com.first.guice.jpa.JpaInitializer;
import com.first.guice.module.JerseyModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by yujuekong on 2017/6/26.
 */
public class JettyServer {
    private static final String DEFAULT_CONTEXT_PATH = "/yu_practice_first";
    private static final String DEFAULT_APP_CONTEXT_PATH = "src/main/webApp";
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext webAppContext = new WebAppContext(DEFAULT_APP_CONTEXT_PATH,DEFAULT_CONTEXT_PATH);
        webAppContext.setDescriptor(DEFAULT_APP_CONTEXT_PATH + "/WEB-INF/web.xml");
        webAppContext.setResourceBase(DEFAULT_APP_CONTEXT_PATH);
        webAppContext.setParentLoaderPriority(true);
        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}
