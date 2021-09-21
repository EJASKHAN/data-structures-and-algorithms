package common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Ejaskhan
 **/
public class Main {

    //int j=0;
    public static void main(String[] args)
    {
       /* Test test = new Test();
        System.out.println(test.i+" "+test.j);*/
        //System.out.println(check());

        Point p = new Point();
        System.out.println("x = " + p.x + ", y = " + p.y);

        /*
        ExpiryTime
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.put(4,4);
        map.put(5,5);

        System.out.println(map);

        map.entrySet().stream().forEach(element ->
                map.remove(element.getKey()));

         Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
         while(iterator.hasNext())
         {
             Map.Entry<Integer,Integer> entry = iterator.next();
             if(entry.getValue().equals(3))
             {
                 iterator.remove();
             }
         }

        System.out.println(map);*/

        Parent x = new Parent();
        Parent y = new Child();
        Child z = new Child();
        DoPrint(x);
        DoPrint(y);
        DoPrint(z);

    }

    public static void DoPrint(Parent o)
    {
        o.Print();
    }

    static int check()
    {
        int j=0;
        //static int j=0;
        return j++;
    }
}

//33
class Point {
    protected int x, y;

    /*public Point(int _x, int _y)
    {
        x = _x;
        y = _y;
    }*/
}

//next

class Parent
{
    public void Print()
    {
        System.out.println("Parent");
    }
}

class Child extends Parent
{
    public void Print()
    {
        System.out.println("Child");
    }
}


