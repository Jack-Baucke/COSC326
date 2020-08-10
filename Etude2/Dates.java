import java.util.Scanner;

public class Dates {

    private static String input;
    private static boolean flag;
    private static int i;
    private static char ch, separator;
    private static int day, month, year;
    private static int separatorIndex1, separatorIndex2;
    private static String[] months = {"OBUNGA", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            flag = true;

            input = scanner.nextLine();

            checkDay();

            if (flag) {
                checkYear();        
            }
            if (flag) {
                checkMonth(); 
            }

            if (flag) {
                checkDate();  
            }

            if (flag == true) {
                if (day < 10) {
                    System.out.println("0" + day + " " + months[month] + " " + year);
                } else {
                    System.out.println(day + " " + months[month] + " " + year);
                }
            }

            // System.out.println("DAY: " + day);
            // System.out.println("MONTH: " + month);
            // System.out.println("YEAR: " + year); 
        }      
    }

    public static void checkDay() {
        for (i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch < 48 || ch > 57) {
                if (ch == '-' || ch == '/' || ch == ' ') {
                    if (i == 0) {
                        System.out.println(input + " - INVALID: Separators must be between day and month and month and year");
                        flag = false;
                        return;
                    } else {
                        separator = ch;
                        separatorIndex1 = i;
                        String dayString = input.substring(0, i);
                        day = Integer.parseInt(dayString);
                        break;
                    }
                } else {
                    System.out.println(input + " - INVALID: Day must be 1 or 2 digits");
                    flag = false;
                    return;
                }
            }
        }
    }

    public static void checkYear() {
        for (i = 0; i < input.length(); i++) {
            ch = input.charAt(input.length() - i - 1);
            if (ch < 48 || ch > 57) {
                if (ch == '-' || ch == '/' || ch == ' ') {
                    if (i < 2) {
                        System.out.println(input + " - INVALID: Year must be 2 or 4 digits long");
                        flag = false;
                        return;
                    }
                    if (ch == separator) {
                        separatorIndex2 = input.length() - i - 1;
                        break;
                    } else {
                        System.out.println(input + " - INVALID: Separators must be the same");
                        separatorIndex2 = input.length() - i - 1;
                        flag = false;
                        return;
                    }
                } else {
                    System.out.println(input + " - INVALID: Year must be written in 2 or 4 digit form");
                    flag = false;
                    return;
                }
            }
        }
        String yearString = input.substring(input.length() - i, input.length());
        //System.out.println("YEAR STR: " + yearString);
        year = Integer.parseInt(yearString);

        if (yearString.length() != 2 && yearString.length() != 4) {
            System.out.println(input + " - INVALID: Year must be written in 2 or 4 digit form");
            System.out.println(yearString);
            flag = false;
            return;
        }

        if (yearString.length() == 2) {
            if (year > 49) {
                year += 1900;
            } else {
                year += 2000;
            }
        }

        if (year < 1753 || year > 3000) {
            System.out.println(input + " - INVALID: Year must be between 1753 and 3000");
            flag = false;
            return;
        }
    }

    public static void checkMonth() {
        
        String monthString = input.substring(separatorIndex1 + 1, separatorIndex2);

        for (int i = 0; i < months.length; i++) {
            if (monthString.equals(months[i]) || monthString.equals(months[i].toUpperCase())) {
                month = i;
                return;
            }
        }

        if (monthString.length() > 2) {
            System.out.println(input + " - INVALID: Month must be 1 or 2 digits or first three letters of month");
            flag = false;
            return;
        }

        for (int i = 0; i < monthString.length(); i++) {
            ch = monthString.charAt(i);
            if (ch < 48 || ch > 57) {
                System.out.println(input + " - INVALID: Month must be in written in numerical form or first 3 letters of month");
                flag = false;
                return;
            }
        }
        month = Integer.parseInt(monthString);      
    }

    public static void checkDate() {
        int separatorCount = 0;
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (ch == ' ' || ch == '-' || ch == '/') {
                separatorCount++;
            }
        }
        if (separatorCount > 2) {
            System.out.println(input + " - INVALID: Date must be in format of DAY <separator> MONTH <separator> YEAR");
            flag = false;
            return;
        }

        // check if day is within months
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31) {
                System.out.println(input + " - INVALID: Day out of range for month");
                flag = false;
                return;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                System.out.println(input + " - INVALID: Day out of range for month");
                flag = false;
                return;
            }
        }
        if (month == 2) {
            if (year % 4 == 0) {
                if (year % 100 != 0 || year % 400 == 0) {
                    if (day > 29) {
                        System.out.println(input + " - INVALID: Day out of range for month");
                        flag = false;
                        return;
                    }
                } else {
                    if (day > 28) {
                        System.out.println(input + " - INVALID: Day out of range for month");
                        flag = false;
                        return;
                    }
                }
            } else {
                if (day > 28) {
                    System.out.println(input + " - INVALID: Day out of range for month");
                    flag = false;
                    return;
                }
            }
            
        }
        
    }
}