package altibbi.utils;

import com.github.javafaker.Faker;
import altibbi.object.User;
import com.github.javafaker.PhoneNumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserUtils {

    public static User generateRandomUser(){
        String firstName = new Faker().name().firstName();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
        int year=  new Faker().number().numberBetween(1950,2024);
        int month= new Faker().number().numberBetween(1,12);
        int date = new Faker().number().numberBetween(1,30);

      //  char thirdDigit = new Faker().options().option('7', '8', '9');

        // Generate the remaining 7 digits
        String remainingDigits = new Faker().number().digits(7);

        // Combine the parts to form the phone number
        String phoneNumber = "+1" + "202" + remainingDigits;
        LocalDate localDate = LocalDate.of(year, month, date);
        // Define the format for the date string
        DateTimeFormatter bdate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Convert LocalDate to formatted string
        String dateString = localDate.format(bdate);
        String limitedPassword = password.length() > 14 ? password.substring(0, 14) : password;



        User user=new User(firstName,lastName,email,limitedPassword,dateString,phoneNumber);
        return user;


    }







}
