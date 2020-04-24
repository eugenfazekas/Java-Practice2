
package getterandsetter;


public class GetterandSetter {

    
    public static void main(String[] args) {

        Human first = new Human();
        
        Human second = new Human();
        
        Human third = new Human();
        
        first.setName("Adrienn");
        
        second.getName();
        
        third.setName("Angela");
        
        third.setAge(18);
        
        System.out.println(first.getName());
        
        System.out.println(second.getName());
        
        System.out.println(third.getName());
        
        System.out.println(third.getAge());
        
        
        if(first.getName() == null) {
            System.out.println("Nincs nev");
        }else {
            System.out.println("Van nev! " + first.getName());
        }
    }
    
}
