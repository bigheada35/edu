### ����
/*
�Ʒ��� �������̽��� ���߾�(����Ͽ�) 
�Ʒ��� ���α׷��� �Ͻÿ�.

Circle, Rectangle , Triangle

*/

```java

interface AreaGetable{
    double getArea();
}


class Circle implements AreaGetable{
   private double r;
   
   public Circle(double r) {
      this.r = r;
   }
   
   @Override
   public double getArea() {
      
      return r * r * Math.PI;
   }   
}

class Rectangle implements AreaGetable{
   
   private double width,height;
   
   public Rectangle(double width,double height) {
      this.height = height;
      this.width = width;
   }
   
   @Override
   public double getArea() {
  
      return width * height;
   }   
}


class CondOp {


    public static void main(String[] args) {
       
       AreaGetable[] area = {new Rectangle(4,5),new Circle(4)};
       
       //AreaGetable oneArea = new Circle(4);
       System.out.println( getAllArea(area) );

       //oneArea = new Rectangle(4,5);
       //System.out.println(area.getArea());      
       
    }
}
```