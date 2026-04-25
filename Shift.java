public class Shift{
//An object of this class represents a work shift. A shift begins on a given date at a given time and ends on a
//given date at a given time.
   private CalendarTime startTime;
   private CalendarTime finishTime;

   //Constructors
   public Shift(CalendarTime start, CalendarTime finish){
   // Create a Shift object representing a shift worked between the given date times.
      this.startTime = start;
      this.finishTime = finish;
      }
        
   //Methods
   public CalendarTime start(){
   // Obtain the start date and time for this shift.
      return startTime;}
      
   public CalendarTime finish(){
   // Obtain the end date and time for this shift.
      return finishTime;}
      
   public boolean inWeek(Week w){
   // Determine whether this shift occurred within the given week.
      return w.includes(startTime.date()) || w.includes(finishTime.date());}
      
   public boolean includesDate(Date date){
   // Determine whether this shift at least partly occurred on the given date.
      return (startTime.date()).compareTo(date)==0 || (finishTime.date()).compareTo(date)==0;
      }
      
   public Duration length(){
   // Obtain the length of this shift.
      Duration len = finishTime.subtract(startTime);
      return len;
      }
   
   public String toString(){
   // Obtain a string representation of this shift of the form "<date>%:<time>-<date>%:<time>".
      return startTime.toString() + " - " + finishTime.toString();
      }}
