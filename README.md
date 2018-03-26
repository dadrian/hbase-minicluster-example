# hbase-minicluster-example
HBase Minicluster Testing using gradle

This repository contains a barebones `build.gradle` that shows how to getting a working `HBaseTestingUtility`.

### Errors

Have you ever attempted to use HBase Minicluster and seen a `NoSuchFieldError`?

```
    java.lang.NoSuchFieldError: IS_SECURITY_ENABLED
        at org.apache.jasper.compiler.JspRuntimeContext.<init>(JspRuntimeContext.java:197)
        at org.apache.jasper.servlet.JspServlet.init(JspServlet.java:150)
        at org.mortbay.jetty.servlet.ServletHolder.initServlet(ServletHolder.java:440)
        at org.mortbay.jetty.servlet.ServletHolder.doStart(ServletHolder.java:263)
        at org.mortbay.component.AbstractLifeCycle.start(AbstractLifeCycle.java:50)
        at org.mortbay.jetty.servlet.ServletHandler.initialize(ServletHandler.java:736)
        at org.mortbay.jetty.servlet.Context.startContext(Context.java:140)
        at org.mortbay.jetty.webapp.WebAppContext.startContext(WebAppContext.java:1282)
        at org.mortbay.jetty.handler.ContextHandler.doStart(ContextHandler.java:518)
        at org.mortbay.jetty.webapp.WebAppContext.doStart(WebAppContext.java:499)
        at org.mortbay.component.AbstractLifeCycle.start(AbstractLifeCycle.java:50)
        at org.mortbay.jetty.handler.HandlerCollection.doStart(HandlerCollection.java:152)
        at org.mortbay.jetty.handler.ContextHandlerCollection.doStart(ContextHandlerCollection.java:156)
        at org.mortbay.component.AbstractLifeCycle.start(AbstractLifeCycle.java:50)
        at org.mortbay.jetty.handler.HandlerWrapper.doStart(HandlerWrapper.java:130)
        at org.mortbay.jetty.Server.doStart(Server.java:224)
```

This is caused by a transitive dependency on Jasper, and can be fixed by a dependency exclude.

Got a `NoSuchMethod` error? Or a `NoSuchClass` error? This is because your Guava version is too new. Pin to 14.0.1.
