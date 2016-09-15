/**
 * Created by jl_ra on 9/13/2016.
 */
public class LukeDate implements Comparable<LukeDate> {
    private static final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private final int month;   // month (between 1 and 12)
    private final int day;     // day   (between 1 and DAYS[month]
    private final int year;    // year

    /**
     * Initializes a new LukeDate from the month, day, and year.
     * @param month the month (between 1 and 12)
     * @param day the day (between 1 and 28-31, depending on the month)
     * @param year the year
     * @throws IllegalArgumentException if this LukeDate is invalid
     */
    public LukeDate(int month, int day, int year) {
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid LukeDate");
        this.month = month;
        this.day   = day;
        this.year  = year;
    }

    /**
     * Initializes new LukeDate specified as a string in form MM/DD/YYYY.
     * @param LukeDate the string representation of this LukeDate
     * @throws IllegalArgumentException if this LukeDate is invalid
     */
    public LukeDate(String LukeDate) {
        String[] fields = LukeDate.split("/");
        if (fields.length != 3) {
            throw new IllegalArgumentException("Invalid LukeDate");
        }
        month = Integer.parseInt(fields[0]);
        day   = Integer.parseInt(fields[1]);
        year  = Integer.parseInt(fields[2]);
        if (!isValid(month, day, year)) throw new IllegalArgumentException("Invalid LukeDate");
    }

    /**
     * Return the month.
     * @return the month (an integer between 1 and 12)
     */
    public int month() {
        return month;
    }

    /**
     * Returns the day.
     * @return the day (an integer between 1 and 31)
     */
    public int day() {
        return day;
    }

    /**
     * Returns the year.
     * @return the year
     */
    public int year() {
        return year;
    }


    // is the given LukeDate valid?
    private static boolean isValid(int m, int d, int y) {
        if (m < 1 || m > 12)      return false;
        if (d < 1 || d > DAYS[m]) return false;
        if (m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }

    // is y a leap year?
    private static boolean isLeapYear(int y) {
        if (y % 400 == 0) return true;
        if (y % 100 == 0) return false;
        return y % 4 == 0;
    }

    /**
     * Returns the next LukeDate in the calendar.
     *
     * @return a LukeDate that represents the next day after this day
     */
    public LukeDate next() {
        if (isValid(month, day + 1, year))    return new LukeDate(month, day + 1, year);
        else if (isValid(month + 1, 1, year)) return new LukeDate(month + 1, 1, year);
        else                                  return new LukeDate(1, 1, year + 1);
    }

    /**
     * Compares two LukeDates chronologically.
     *
     * @param  that the other LukeDate
     * @return {@code true} if this LukeDate is after that LukeDate; {@code false} otherwise
     */
    public boolean isAfter(LukeDate that) {
        return compareTo(that) > 0;
    }

    /**
     * Compares two LukeDates chronologically.
     *
     * @param  that the other LukeDate
     * @return {@code true} if this LukeDate is before that LukeDate; {@code false} otherwise
     */
    public boolean isBefore(LukeDate that) {
        return compareTo(that) < 0;
    }

    /**
     * Compares two LukeDates chronologically.
     *
     * @return the value {@code 0} if the argument LukeDate is equal to this LukeDate;
     *         a negative integer if this LukeDate is chronologically less than
     *         the argument LukeDate; and a positive ineger if this LukeDate is chronologically
     *         after the argument LukeDate
     */
    @Override
    public int compareTo(LukeDate that) {
        if (this.year  < that.year)  return -1;
        if (this.year  > that.year)  return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day   < that.day)   return -1;
        if (this.day   > that.day)   return +1;
        return 0;
    }

    /**
     * Returns a string representation of this LukeDate.
     *
     * @return the string representation in the format MM/DD/YYYY
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Compares this LukeDate to the specified LukeDate.
     *
     * @param  other the other LukeDate
     * @return {@code true} if this LukeDate equals {@code other}; {@code false} otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        LukeDate that = (LukeDate) other;
        return (this.month == that.month) && (this.day == that.day) && (this.year == that.year);
    }

    /**
     * Returns an integer hash code for this LukeDate.
     *
     * @return an integer hash code for this LukeDate
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31*hash + month;
        hash = 31*hash + day;
        hash = 31*hash + year;
        return hash;
    }

    /**
     * Unit tests the {@code LukeDate} data type.
     *
     * @param args the command-line arguments
     */
    public String dayOftheWeek() {
        int nodays, noofWeek;
        nodays = day;
        for(int i = 1; i < month; i++) {
            if (i == 2 && !isLeapYear(year)) nodays = nodays + 28;
            else nodays = nodays + DAYS[i];
        }
        for(int i=2000; i < year; i++){
            if(isLeapYear(i))nodays = nodays + 366;
            else nodays = nodays + 365;
        }
        noofWeek = nodays % 7;
        switch (noofWeek) {
            case 1: return "Saturday";
            case 2: return "Sunday";
            case 3: return "Monday";
            case 4: return "Tuesday";
            case 5: return "Wednesday";
            case 6: return "Thursday";
            case 0: return "Friday";
            default: return "Error";

        }
    }
    public static void main(String[] args) {
        LukeDate today = new LukeDate(2, 25, 2004);
        System.out.println(today);
        for (int i = 0; i < 10; i++) {
            today = today.next();
            System.out.println(today);
        }

        System.out.println(today.isAfter(today.next()));
        System.out.println(today.isAfter(today));
        System.out.println(today.next().isAfter(today));


        LukeDate birthday = new LukeDate(10, 16, 1971);
        System.out.println(birthday);
        for (int i = 0; i < 10; i++) {
            birthday = birthday.next();
            System.out.println(birthday);
        }
    }

}
