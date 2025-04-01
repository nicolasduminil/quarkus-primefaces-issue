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
      config.getValue("my.prop", String.class);
    }
    catch (NoSuchElementException e)
    {
      e.printStackTrace();
    }
  }
}
