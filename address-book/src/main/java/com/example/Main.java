package com.example;
import java.util.List;
import java.util.Scanner;


import java.io.IOException;

public class Main {
    public static void main(String[] args)  throws IOException{
        AddressBook addressBook = new AddressBook(); 
        String fileName="AddressBook_Data.txt";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Contact and write in file");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Address Book");
            System.out.println("5. Add Multiple Contacts");
            System.out.println("6. Search by City");
            System.out.println("7. Search by State");
            System.out.println("8. Read File Data");
            System.out.println("9. Sort by Name");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
              
                case 1:
                    // Add Contact
                    System.out.print("Enter the name of the Address Book: ");
                    String addBookName = scanner.nextLine();
                    Contact newContact = createContactFromConsole();
                    
                    addressBook.addContact(addBookName, newContact);
                    addressBook.writeToFile(fileName);
                    
                    break;

                case 2:
                    // Edit Contact
                    System.out.print("Enter the name of the Address Book: ");
                    String editBookName = scanner.nextLine();
                    System.out.print("Enter the first name of the contact to edit: ");
                    String editName = scanner.nextLine();
                    Contact editedContact = createContactFromConsole();
                    addressBook.editContact(editBookName, editName, editedContact);
                    System.out.println("Contact edited successfully!");
                    
                    addressBook.writeToFile(fileName);
                    
                    break;

                case 3:
                    // Delete Contact
                    System.out.print("Enter the name of the Address Book: ");
                    String deleteBookName = scanner.nextLine();
                    System.out.print("Enter the first name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteBookName, deleteName);
                    System.out.println("Contact deleted successfully!");
                    
                    addressBook.writeToFile(fileName);
                    
                    break;

                case 4:
                    // Display Address Book
                    System.out.print("Enter the name of the Address Book: ");
                    String displayBookName = scanner.nextLine();
                    System.out.println("\nCurrent Address Book:");
                    addressBook.getContacts(displayBookName).forEach(System.out::println);
                    break;

                case 5:
                    // Add Multiple Contacts
                    System.out.print("Enter the name of the Address Book: ");
                    String addMultipleBookName = scanner.nextLine();
                    System.out.print("Enter the number of contacts to add: ");
                    int numberOfContacts = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    for (int i = 0; i < numberOfContacts; i++) {
                        System.out.println("\nAdding Contact #" + (i + 1));
                        Contact multipleContact = createContactFromConsole();
                        addressBook.addContact(addMultipleBookName, multipleContact);
                    }

                    System.out.println("Multiple contacts added successfully!");
                    break;

                case 6:
                    // Search by City
                    System.out.print("Enter the name of the Address Book: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter the city to search: ");
                    String cityToSearch = scanner.nextLine();
                    List<Contact> citySearchResult = addressBook.searchByCity(bookName, cityToSearch);
                    displaySearchResult(citySearchResult);
                    break;

                case 7:
                    // Search by State
                    System.out.print("Enter the name of the Address Book: ");
                    bookName = scanner.nextLine();
                    System.out.print("Enter the state to search: ");
                    String stateToSearch = scanner.nextLine();
                    List<Contact> stateSearchResult = addressBook.searchByState(bookName, stateToSearch);
                    displaySearchResult(stateSearchResult);
                    break;
                    
                case 8:
                    addressBook.readFile(fileName);
                    break;

                case 9:
                    System.out.println("Enter name of AddressBook");
                    addBookName=scanner.nextLine();
                    List<Contact> contacts=addressBook.sortEntriesByName(addBookName);
                    contacts.forEach(System.out::println);
                    break;

                case 10:
                    // Exit
                    System.out.println("Exit !!!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        //    scanner.close();
        }
    }

    private static Contact createContactFromConsole() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();

        System.out.print("Enter First Name: ");
        contact.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        contact.setLastName(scanner.nextLine());

        System.out.print("Enter Address: ");
        contact.setAddress(scanner.nextLine());

        System.out.print("Enter City: ");
        contact.setCity(scanner.nextLine());

        System.out.print("Enter State: ");
        contact.setState(scanner.nextLine());

        System.out.print("Enter Zip: ");
        contact.setZip(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        contact.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter Email: ");
        contact.setEmail(scanner.nextLine());

        return contact;
    }

    private static void displaySearchResult(List<Contact> result) {
        if (result.isEmpty()) {
            System.out.println("No matching contacts found.");
        } else {
            System.out.println("\nSearch Result:");
            result.forEach(System.out::println);
        }
    }
}
