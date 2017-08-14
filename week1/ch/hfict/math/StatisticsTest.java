package ch.hfict.math;

public class StatisticsTest{

 public static void main (String [] args){
  Statistics stat = new Statistics(3);
  stat.addNumber(1.0);
  stat.addNumber(2.0);
  stat.addNumber(3.0);

  System.out.println(stat.getAverage());
 }
}
