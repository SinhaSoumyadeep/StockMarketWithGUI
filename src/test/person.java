package test;

import java.io.Serializable;
import java.util.List;

public class person {
  private String first;
  private List<Address> addr;

  public person(String first, List<Address> addr){
    this.addr = addr;
    this.first = first;
  }
}
