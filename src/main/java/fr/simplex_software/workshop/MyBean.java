package fr.simplex_software.workshop;

import io.smallrye.config.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

import java.util.NoSuchElementException;

@Named
@ViewScoped
public class MyBean
{
  @Inject
  private SmallRyeConfig config;

  public void submit()
  {
    try
    {
      System.out.println (">>> MyBean.submit(): Expecting to catch a NoSuchElememntException");
      config.getValue("my.prop", String.class);
      System.out.println (">>> MyBean.submit(): We never come here, showing that an exception is raised, but silently.");
    }
    catch (NoSuchElementException e)
    {
      System.out.println (">>> MyBean.submit(): The expected exception is raised, and we are able to catch it");
      e.printStackTrace();
    }
  }
}
