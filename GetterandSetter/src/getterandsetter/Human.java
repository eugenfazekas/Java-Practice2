package getterandsetter;


public class Human {
     String name ;
    
     int age;
     
     String getName() {
         return this.name;
     }
     void setName(String incoming) {
        this.name = incoming;
     }
     int getAge() {
         return this.age;
     }
     void setAge(int incoming){
         this.age = incoming;
     }
}
