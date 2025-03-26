# Quarkus PrimeFaces Extension - Can't create Facelets composite components

This project is a reproducer of the Isuue # ... registered with Quarkusio support. 
It allows to reproduce the issue described below, related to the `quarkus-primefaces`
and `quarkus-primefaces-extensions`, relative to the definition of the Facelets
composite components.

The current project uses Faceletes templates to promote reusing parts of a simple UI
and, among others, defines a composite component, as follows:

  - the file `index.xhtml` refers to the the template defines in `template.xhtml`;
  - the file `template.xhtml` divides the UI single page in two regions: a navbar and a content;
  - the nav bar above defines a menu with a submenu which, when triggered, navigates to `tabview.xhtml`;
  - the file `tabview.xhtml` defines the `content`, as specified by `template.xhtml`. This content is a `tabview` which single `tab` is defined as a Facelets composite component, in the file `composite.xhtml`;

Running this reproducer, as follows;

    $ git clone https://github.com/nicolasduminil/quarkus-primefaces-issue
    $ cd
    $ mvn package
    $ java -jar target/quarkus-app/quarkus-run.jar

will display a simple UI having, in the upper leftmost corner, a menu bar, with
2 menu items, labeled `Home` and `Test`. Clicking on the `Test` menu item, a submenu
labeled `Using composites` appears.

Clicking this submenu, all the GUI's element are displayed as expected, but the `tab` control making 
the object of the Facelets composite component, which isn't displayed. 
No error message, no exception is raised.

Here is a screen copy:

![screen](./screen.png)