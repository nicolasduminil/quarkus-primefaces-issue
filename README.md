# Quarkus PrimeFaces:  Can't place customized content in a menuItem column

This project is a reproducer of the Isuue #448 registered with Quarkusio support. 
It allows to reproduce the issue described below, related to the `quarkus-primefaces`
and `quarkus-primefaces-extensions`, relative to the definition of the exception handling.

This test exposes a very basic page containing a `megaMenu` having a `graphicImage`
in one of its `column`. Trying to render the `xhtml` page raises the following exception:

    2026-01-28 14:30:53,686 SEVERE [org.apache.myfaces.context.ExceptionHandlerImpl] (executor-thread-1) java.lang.ClassCastException occurred while processing RENDER_RESPONSE [Location=]: java.lang.ClassCastException: class org.apache.myfaces.view.facelets.compiler.UIInstructions cannot be cast to class org.primefaces.model.menu.MenuElement (org.apache.myfaces.view.facelets.compiler.UIInstructions and org.primefaces.model.menu.MenuElement are in unnamed module of loader io.quarkus.bootstrap.runner.RunnerClassLoader @13221655)
        at org.primefaces.component.megamenu.MegaMenuRenderer.encodeColumn(MegaMenuRenderer.java:209)
        at org.primefaces.component.megamenu.MegaMenuRenderer.encodeRootSubmenu(MegaMenuRenderer.java:182)
        at org.primefaces.component.megamenu.MegaMenuRenderer.encodeRootItems(MegaMenuRenderer.java:116)
        at org.primefaces.component.megamenu.MegaMenuRenderer.encodeMarkup(MegaMenuRenderer.java:91)
        at org.primefaces.component.menu.BaseMenuRenderer.encodeEnd(BaseMenuRenderer.java:59)
        at jakarta.faces.component.UIComponentBase.encodeEnd(UIComponentBase.java:634)
        at jakarta.faces.component.UIComponentBase.encodeAll(UIComponentBase.java:523)
        at jakarta.faces.component.UIComponentBase.encodeAll(UIComponentBase.java:519)
        at jakarta.faces.component.UIComponentBase.encodeAll(UIComponentBase.java:519)
        at jakarta.faces.component.UIComponentBase.encodeAll(UIComponentBase.java:519)
        at org.apache.myfaces.view.facelets.FaceletViewDeclarationLanguage.renderView(FaceletViewDeclarationLanguage.java:1779)
        at org.apache.myfaces.application.ViewHandlerImpl.renderView(ViewHandlerImpl.java:316)
        at org.apache.myfaces.lifecycle.RenderResponseExecutor.execute(RenderResponseExecutor.java:122)
        at org.apache.myfaces.lifecycle.LifecycleImpl.render(LifecycleImpl.java:241)

Running this reproducer, as follows;

    $ git clone https://github.com/nicolasduminil/quarkus-primefaces-issue
    $ cd quarkus-primefaces-issue
    $ mvn package
    $ java -jar target/quarkus-app/quarkus-run.jar
    $ open http://localhost:8080
