import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PetRegistry {
    private List<Animal> animals;
    private static int animalCount = 0;

    public PetRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        animalCount++;
    }

    public List<String> getAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal.getCommands();
            }
        }
        return null;
    }

    public void teachNewCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.addCommand(command);
                break;
            }
        }
    }

    public List<Animal> getAnimalsSortedByBirthDate() {
        animals.sort(Comparator.comparing(Animal::getBirthDate));
        return animals;
    }

    public static int getAnimalCount() {
        return animalCount;
    }}