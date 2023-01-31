
/**
 * DateWeightYoungHumanDriver class:
 * This is used to test the Date, Weight, and YoungHuman classes
 *
 * @author David Nixon
 * @version 2021
 */
public class DateWeightYoungHumanDriver
{
    public static void main(String [] args){
        /* *** DATE TESTS:  *** */
        System.out.println("Date tests:");
        System.out.println("-----------");
        // construct some date objects and do some tests:
        Date d1 = new Date(6,7,2019);
        System.out.println("Testing getMonth(). Should print 6: " + d1.getMonth());
        // now add many more tests!
        System.out.println("testing getDay(), should print 7: " + d1.getDay());
        System.out.println("Testing getYear(), should print 2019: " + d1.getYear());
        Date d2 = new Date(4, 12, 2021);
        
        /* *** WEIGHT TESTS:  *** */
        System.out.println(/* spacer */);
        System.out.println("Weight tests:");
        System.out.println("-------------");
        // construct some Weight objects and do some tests:
        Weight w1 = new Weight(14,8);
        System.out.println("Testing getWeight(). Should print 14.5: " + w1.getWeight());
        // now add many more tests!
        System.out.println("testing getPounds(), should print 14: " + w1.getPounds());
        System.out.println("testing getOunces(), should print 8: " + w1.getOunces());
        Weight w2 = new Weight(5, 12);
        
        /* *** YOUNGHUMAN TESTS:  *** */
        System.out.println(/* spacer */);
        System.out.println("YoungHuman tests:");
        System.out.println("-----------------");
        // construct some YoungHuman objects and do some tests:
        YoungHuman y1 = new YoungHuman(w1, d1, "Homer", "Simpson");
        System.out.print("Testing getName(): ");
        if (y1.getName().equals("Homer Simpson"))
            System.out.println(" TEST PASSED! :) ");
        else System.out.println(" TEST FAILED!  :( ");
        // now add many more tests!
        YoungHuman y2 = new YoungHuman(w2, d2, "Bell", "Cranel");
        System.out.println("testing equals(), should print false: " + y1.equals(y2));
        y2.setLastCheckupDate(d1);
        System.out.println("testing hasHadCheckup(), should print true: " + y2.hasHadCheckup());
        
    }
}
