package fr.simplex_software.workshop;

import jakarta.enterprise.context.*;
import jakarta.faces.view.*;
import jakarta.inject.*;

@Named
@ViewScoped
public class MyBean
{
  public void submit()
  {
    System.out.println("Hello World!");
  }
}
