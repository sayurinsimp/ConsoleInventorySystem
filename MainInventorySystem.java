import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class MainInventorySystem
{

    public static final int ADD_NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int DELETE_ITEM = 3;
    public static final int EXIT_PROGRAM = 4;


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();
        int userChoice = 0;
        while (true)

        try
        {

            System.out.println("Inventory ni Joross & Frans\n");

            do
            {
                System.out.println("What would you like to do?");
                System.out.println("[1] Add New Item\n[2] Edit Item\n[3] Delete Item\n[4] Exit Program");
                try
                {
                    userChoice = scanner.nextInt();

                }
                catch (InputMismatchException invalidInput) {
                    System.out.println("Please enter [1 - 4].");
                    scanner.nextLine();
                }


                switch (userChoice)
                {
                    case ADD_NEW_ITEM:
                        System.out.println("You have chosen to: Add a New Item\n");
                        while (true)
                        {
                            System.out.println("Enter item ID: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();

                            System.out.println("Enter item name: ");
                            String name = scanner.nextLine();

                            System.out.println("Enter item quantity: ");
                            int quantity = Integer.parseInt(scanner.nextLine());

                            System.out.println("Enter item type: ");
                            String type = scanner.nextLine();

                            System.out.println("Enter item size [S/M/L]: ");
                            String size = scanner.nextLine();

                            Item item = new Item(id, name, quantity, type, size);
                            items.add(item);

                            System.out.println("Item added to inventory: " + item);

                            System.out.println("Do you wish to add another item? (y/n)");
                            String choice = scanner.nextLine();

                            if (!choice.equalsIgnoreCase("y"))
                            {
                                break;
                            }

                        }

                        System.out.println("Inventory: \n");
                        for (Item item : items)
                        {
                            System.out.println(item);
                        }
                        System.out.println();
                        break;

                    case EDIT_ITEM:

                        System.out.println("You have chosen to: Edit an Existing Item");

                        if (items.size() == 0)
                        {
                            System.out.println("You cannot edit anything since there are " + 0 + " item(s) imported.\n");
                            break;
                        }

                        boolean editFound = false;
                        Item itemToUpdate = null;

                        System.out.println("There are " + items.size() + " item(s) imported.");
                        System.out.println("The items are the following: \n");

                        for (Item item : items)
                        {
                            System.out.println(item);
                        }
                        System.out.println();

                        while (!editFound)
                        {
                            System.out.println("Enter the item ID of the item you want to update: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();

                            for (Item item : items)
                            {
                                if (item.getId() == id)
                                {
                                    itemToUpdate = item;
                                    editFound = true;
                                    break;
                                }
                            }

                            if (!editFound)
                            {
                                System.out.println("ID not found: " + id);
                            }
                        }

                        if (itemToUpdate != null)
                        {
                            System.out.println("Enter the new name for the item: ");
                            String name = scanner.nextLine();
                            itemToUpdate.setName(name);

                            System.out.println("Enter the new quantity for the item: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            itemToUpdate.setQuantity(quantity);

                            System.out.println("Enter the new type for the item: ");
                            String type = scanner.nextLine();
                            itemToUpdate.setType(type);

                            System.out.println("Enter the new size for the item [S/M/L]: ");
                            String size = scanner.nextLine();

                            itemToUpdate.setSize(size);

                        }

                        System.out.println("Updated item: " + itemToUpdate);
                        break;


                    case DELETE_ITEM:

                        boolean deleteFound = false;
                        Item itemToDelete = null;

                        System.out.println("You have chosen to: Delete an Existing Item");

                        if (items.size() == 0)
                        {
                            System.out.println("You cannot delete anything since there are " + 0 + " item(s) imported.\n");
                            break;
                        }

                        System.out.println("There are " + items.size() + " item(s) imported.");
                        System.out.println("The items are the following: \n");

                        for (Item item : items)
                        {
                            System.out.println(item);
                        }

                        System.out.println();

                        while (!deleteFound)
                        {
                            System.out.println("Enter the item ID of the item you want to delete: ");
                            long id = scanner.nextLong();
                            scanner.nextLine();

                            for (Item item : items)
                            {
                                if (item.getId() == id) {
                                    itemToDelete = item;
                                    deleteFound = true;
                                    break;
                                }
                            }

                            if (!deleteFound)
                            {
                                System.out.println("ID not found: " + id);
                            }
                        }

                        if (itemToDelete != null)
                        {
                            System.out.println("Item found: " + itemToDelete);
                            System.out.println("Do you want to delete this item? (Y/N)");
                            String confirm = scanner.nextLine();

                            if (confirm.equalsIgnoreCase("Y"))
                            {
                                items.remove(itemToDelete);
                                System.out.println("Item successfully deleted!");
                            }
                            else
                            {
                                System.out.println("Deletion cancelled.");
                            }
                        }
                        break;

                    case EXIT_PROGRAM:
                        System.out.println("Thank you for using the program!");
                        System.exit(0);

                    default:
                        System.out.println("Please enter a valid value!");
                        continue;

                }
            }
            while (true);
        }
        catch (Exception a)
        {
            System.out.println("Please enter a valid input!");
            continue;
        }

    }
} 