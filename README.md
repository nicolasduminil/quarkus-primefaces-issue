# Quarkus PrimeFaces Extension -Can't catch NoSuchElementException

This project is a reproducer of the Isuue #337 registered with Quarkusio support. 
It allows to reproduce the issue described below, related to the `quarkus-primefaces`
and `quarkus-primefaces-extensions`, relative to the definition of the exception handling.

In order to reproduce an issue related to the exception handling by the `quarkus-
primefaces` extension, this test exposes a very basic page containing a form and
a button. Clicking the button, the backing bean action is called and it tries 
to get a property from the `application.properties` file, using SmallRye Config
Microprofile. Since the mentioned property doesn't exist, the `NoSuchElememnt`
exception should be caught. However, no exception is raised.

Running this reproducer, as follows;

    $ git clone https://github.com/nicolasduminil/quarkus-primefaces-issue
    $ cd
    $ mvn package
    $ java -jar target/quarkus-app/quarkus-run.jar
