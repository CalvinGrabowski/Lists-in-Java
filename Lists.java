//Advance Topics
//Lists (Chapter 11.1)
//Calvin Grabowski

import java.util.*;


public class Lists {

   public static void main(String[] args) {
      
      //this is the creation of all the lists and even used different sized lists for the alternating list
      LinkedList firstL = new LinkedList();
      LinkedList secL = new LinkedList();
      LinkedList thirdL = new LinkedList();
      LinkedList fourthL = new LinkedList();
      LinkedList fifthL = new LinkedList();
      
      for(int i = 0; i < 15; i++) {
         firstL.add(i);
      }
      for(int i = 0; i < 10; i++) {
         secL.add(20);
         thirdL.add(3 + i);
         thirdL.add(3);
         fourthL.add((int)(10 * Math.random()+1));
         fifthL.add((int)(10 * Math.random()+1));
      }
      
      //this prints all the lists and explanations of what they do
     
      System.out.println("Alternating lists plug in the numbers by alternating from the front of each list.");
      System.out.println("Before: " + firstL + " + " + secL);
      System.out.println("After: " + Lists.alternate(firstL,secL));
      
      System.out.println("\nRemoves the number 3 with in range of 10 to 200.");
      System.out.println("Before: " + thirdL);
      System.out.println("After: " + Lists.removeInRange(thirdL,3,10,200));
      
      System.out.println("\nPartition makes anything below or equal to the baseline(5) goes to the left of the list.");
      System.out.println("Before: " + fourthL);
      System.out.println("After: " + Lists.partition(fourthL,5));
      
      System.out.println("\nSorts and remove duplicates sorts the list in numerical order and gets rid of duplicate numbers.");
      System.out.println("Before: " + fifthL);
      System.out.println("After: " + sortAndRemoveDupicates(fifthL));
     
      
   }
   
   //this adds two lists and combines them into one list after alternating taking from list 1 to 2
   public static LinkedList alternate(LinkedList list1, LinkedList list2) {
   
      LinkedList rList = new LinkedList();
      //runs until all the lists are done grabing one from list1 then 2 repeatedly
      while((!list1.isEmpty() || !list2.isEmpty())) {
         if(!list1.isEmpty()) {
            rList.add(list1.remove());
         }
         if(!list2.isEmpty()) {
            rList.add(list2.remove());
         }
      }
      return rList;
   }
   
   //removes all the remove variable numbers in between the interval (start, finish)
   public static LinkedList removeInRange(LinkedList list3, int remove, int start, int finish) {
   
     //makes an interator that starts at the start
      Iterator<Integer> itr = list3.iterator();
      for(int i = 0; i < start; i++) {
         itr.next();
      }
      
      //goes from start to finish if the finish is out of the loop it ends automatically
      //the loop takes all the number "remove"'s and gets rid of them
      while(itr.hasNext() && start < finish) {    
         int holder = itr.next();         
         if(remove == holder) {
            itr.remove();
         }
         start++;
      }
      return list3;
   }
   
   //this sorts everything to be above or below the baseline. Not sorting it numerically but based off one baseline
   public static LinkedList partition(LinkedList list4, int baseLine) {
   
      Iterator<Integer> itr = list4.iterator();
      LinkedList list5 = new LinkedList();
      
     //makes an iterator to find all the numbers under the base line in list4 and adds it to list5
      while(itr.hasNext()) {
         int work = itr.next();
         if(work <= baseLine) {
            itr.remove();
            list5.add(work);
         }
      }
      //adds all the rest of the numbers to list5
      while(list4.size() > 0) {
         list5.add(list4.remove());
      } 
      return list5;
   }
   
   //this sorts the list and removes all the duplicate numbers
   public static LinkedList sortAndRemoveDupicates(LinkedList list6) {
      Iterator<Integer> itr = list6.iterator();
     
      int max = itr.next();
      int min = max;
      
      //this gets the max and min of the list
      while(itr.hasNext()) {
         int holder = itr.next();
         if(holder > max) {
            max = holder;
         }
         if(holder < min) {
            min = holder;
         }
      }
      
      LinkedList list7 = new LinkedList();  //this is the list that ends up with all the stuff
      
      //this for loop has a while loop in it so it can go up by 1 from the min to the max looping through each number 
      //through the list to find if there is a copy of that number and adding it to a new list after that and jumping 
      //to the next loop number because it wants to get rid of duplicates so there is not a point to looping through the rest
      for(int i = min; i <= max; i++) {
         Iterator<Integer> itrs = list6.iterator();
         //this iterator goes through the list and finds the minimum and maximum of the list
         
         int stuff = itrs.next();
         //stuff holds the current number in the list and is being compared to the loop number
         
         while(itrs.hasNext()) {
            //this goes through on the current count and finds if there is a copy of the loop number in the list
            //if so it adds it to another list and skips to the next loop by breaking the loop
            //System.out.print(stuff + " < -- " + (stuff == i) + "  current -- > " + i);
            stuff = itrs.next();
            if(i == stuff) {
               list7.add(stuff);
               break;
            }
         }
      }
      
      return list7; 
   }


}