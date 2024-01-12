package service;

import model.Address;
import model.User;
import repository.UserRepository;
import utility.Validation;

import java.sql.SQLException;
import java.util.Scanner;

public class UserService {

    private final Scanner scanner = new Scanner(System.in);
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void singUp() throws SQLException {
        System.out.println("Please enter your firstname:");
        String firstname = scanner.nextLine();

        System.out.println("Please enter your lastname:");
        String lastname = scanner.nextLine();

        String nationalId = "";
        while (true) {
            System.out.println("Please Enter your national ID");
            nationalId = scanner.nextLine();
            if (Validation.validateMelliCode(nationalId)) {
                break;
            } else {
                System.out.println("Enter the correct form of national ID");
            }
        }

        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        String password = "";
        while(true) {
            System.out.println("Please enter your password:");
            password = scanner.nextLine();
            if(Validation.isValidPassword(password)){
                break;
            }else{
                System.out.println("Enter correct password");
            }
        }

        User user = new User(firstname, lastname, nationalId, username, password);
        int result = userRepository.registerUser(user);
        if (result == 1)
            System.out.println(firstname + " you successfully register :)");
        else
            System.out.println("something is wrong :|");
    }

    public void signIn() throws SQLException {
        System.out.println("Please enter your username:");
        String username = scanner.nextLine();

        System.out.println("Please enter your password");
        String password = scanner.nextLine();

        User user = userRepository.findByUsername(username);
        if (user == null)
            System.out.println("Please register first");
        else if (!user.getPassword().equals(password))
            System.out.println("Please enter correct password");
        else
            System.out.println("WELCOME " + user.getUsername());
    }
    public  void getAddressFromUser () throws SQLException {
        System.out.println("please enter your country: ");
        String country =scanner.nextLine();
        System.out.println("please enter your provinc: ");
        String provinc =scanner.nextLine();
        System.out.println("please enter your city: ");
        String city =scanner.nextLine();
        System.out.println("please enter your street: ");
        String street =scanner.nextLine();
        System.out.println("please enter your alley: ");
        String alley =scanner.nextLine();
        System.out.println("please enter your number: ");
        int number =scanner.nextInt();
        scanner.nextLine();
        System.out.println("please enter your userid : ");
        int userid =scanner.nextInt();
        scanner.nextLine();

        Address address=new Address(country,provinc,city,street,alley,number,userid);
        int result =userRepository.addUserAddress(address);
        if(result==1)
            System.out.println("the address successfully added");
        else
            System.out.println("error");
    }
}
