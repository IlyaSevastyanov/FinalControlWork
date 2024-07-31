
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetRegistry registry = new PetRegistry();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Add new animal");
            System.out.println("2. List animal commands");
            System.out.println("3. Teach new command");
            System.out.println("4. List animals by birth date");
            System.out.println("5. Get animal count");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter type of animal (dog, cat, hamster, horse, camel, donkey): ");
                    String type = scanner.nextLine().toLowerCase();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter birth date (YYYY-MM-DD): ");
                    String birthDate = scanner.nextLine();
                    Animal animal;
                    switch (type) {
                        case "dog":
                            animal = new Dog(name, birthDate);
                            break;
                        case "cat":
                            animal = new Cat(name, birthDate);
                            break;
                        case "hamster":
                            animal = new Hamster(name, birthDate);
                            break;
                        case "horse":
                            animal = new Horse(name, birthDate);
                            break;
                        case "camel":
                            animal = new Camel(name, birthDate);
                            break;
                        case "donkey":
                            animal = new Donkey(name, birthDate);
                            break;
                        default:
                            System.out.println("Unknown animal type.");
                            continue;
                    }
                    registry.addAnimal(animal);
                    break;
                case 2:
                    System.out.print("Enter animal name: ");
                    name = scanner.nextLine();
                    List<String> commands = registry.getAnimalCommands(name);
                    if (commands != null) {
                        System.out.println("Commands: " + commands);
                    } else {
                        System.out.println("Animal not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter animal name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new command: ");
                    String command = scanner.nextLine();
                    registry.teachNewCommand(name, command);
                    break;
                case 4:
                    List<Animal> sortedAnimals = registry.getAnimalsSortedByBirthDate();
                    for (Animal sortedAnimal : sortedAnimals) {
                        System.out.println(sortedAnimal);
                    }
                    break;
                case 5:
                    System.out.println("Total animals: " + PetRegistry.getAnimalCount());
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}