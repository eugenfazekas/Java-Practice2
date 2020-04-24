package phonebook;

import javafx.beans.property.SimpleStringProperty;




public class Person {
   
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleStringProperty email;
    private final SimpleStringProperty id;

  public Person()  {
      
      this.lastName  = new SimpleStringProperty("");
      this.firstName = new SimpleStringProperty("");
      this.email     = new SimpleStringProperty("");
      this.id        = new SimpleStringProperty ("");
  }
    
  public Person(String lname, String fname, String email)  {
      
      this.lastName  = new SimpleStringProperty(lname);
      this.firstName = new SimpleStringProperty(fname);
      this.email     = new SimpleStringProperty(email);
      this.id        = new SimpleStringProperty ("");
  }
 
  public Person(Integer id,String lname, String fname, String email)  {
      
      this.lastName  = new SimpleStringProperty(lname);
      this.firstName = new SimpleStringProperty(fname);
      this.email     = new SimpleStringProperty(email);
      this.id        = new SimpleStringProperty (String.valueOf(id));
  }
  
   public String getFirstName() {
      return firstName.get();           
  }
  
   public void setFirstName(String fname) {
      firstName.set(fname);
  }
   public String getLastName() {
      return lastName.get();
  }
  
   public  void setLastName(String fname) {
      lastName.set(fname);
  }
   public String getEmail() {
      return email.get();
  }
  
   public void setEmail(String fname) {
      email.set(fname);
  }
     public String getId() {
      return id.get();
  }
  
   public void setId(String fname) {
      id.set(fname);
  }
}