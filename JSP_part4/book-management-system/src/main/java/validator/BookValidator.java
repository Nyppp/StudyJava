package validator;

import java.sql.Date;

public class BookValidator {
    private static final int titleLength = 200;
    private static final int authorLength = 100;

    private static final int maxPrice = 1000000;
    private static final int minPrice = 0;

    private static final int descriptionLength = 1000;

    public static boolean checkTitle(String title){
        if(title.length() > titleLength || title.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkAuthor(String author){
        if(author.length() > authorLength || author.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkPrice(String price){
        if(price.equals("")){
            return false;
        } else{
            try {
                int intPrice = Integer.parseInt(price);
                if(intPrice > maxPrice || intPrice < minPrice){
                    return false;
                }else{
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    public static boolean checkDescription(String description){
        if(description.length() > descriptionLength || description.equals("")){
            return false;
        }else{
            return true;
        }
    }

    public static boolean checkDate(String date){
        try{
            Date.valueOf(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
