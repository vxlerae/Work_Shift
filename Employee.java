//Class to represent an employee for time keeping during work shifts
//Date: 13 September 2023
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employee{
   private String employeeName;
   private String uid;
   private List<Shift> shiftList;
   private CalendarTime calendarIn;
   private CalendarTime calendarOut;
   
   
   public Employee(String name, String uid){
 
      this.employeeName = name;
      this.uid = uid;
      this.shiftList = new ArrayList<Shift>();
      this.calendarIn = null;
      }
      
   public String name(){
      return employeeName;
      }
      
   public String UID(){
      return uid;
      }
      
   public void signIn(Date d, Time t){
        calendarIn = new CalendarTime(d, t); 
      }
      
      
   public void signOut(Date d, Time t){
      Shift shiftOut = new Shift(calendarIn, new CalendarTime(d, t));
      shiftList.add(shiftOut);
      calendarIn = null;
      }
   
   public boolean present(){
      return calendarIn != null;
      }
   
   public boolean worked(Date d){
      return d.compareTo(calendarIn.date())==0 || d.compareTo(calendarOut.date())==0;
      }
   
   public boolean worked(Week w){
      return w.includes(calendarIn.date()) || w.includes(calendarOut.date());
      }
      
   public List<Shift> get(Date d){ 
      List<Shift> values = new ArrayList<Shift>();
      for(Shift shift: shiftList){
         if (shift.includesDate(d)){
            values.add(shift);}}
            return values;}
   
   public List<Shift> get(Week w){
      List<Shift> values = new ArrayList<Shift>();
      for(Shift shift : shiftList){
         if(shift.inWeek(w)){
            values.add(shift);
            }}
          return values;}
          
   
   public Duration hours(Week w){
      List<Shift> shiftList = get(w);
      Duration lengthShift = Duration.ZERO;
      for(Shift x: shiftList){
         lengthShift = lengthShift.add(x.length());
         }
      return lengthShift;
      }}
