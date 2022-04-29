package be.intectbrussel;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingWritingApp {
    public static void main(String[] args) throws FileNotFoundException {

        Path messagePath = Path.of("../../FromJereToPearl/message.txt");
        Path animalPath = Path.of("../../FromJereToPearl/animal.txt");

        try {
            if (Files.notExists(messagePath.getParent())){
                Files.createDirectories(messagePath.getParent());
                System.out.println("Directory created");
            } else {
                System.out.println("Directory already exists");
            }
            if (Files.notExists(messagePath)){
                Files.createFile(messagePath);
                System.out.println("message.txt has been created");
            } else {
                System.out.println("message.txt already exists");
            }
            if (Files.notExists(animalPath)){
                Files.createFile(animalPath);
                System.out.println("animal.txt has been created");
            }else {
                System.out.println("animal.txt already exists");
            }
        } catch (IOException e){
            e.getStackTrace();
        }

        System.out.println();

        try (BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(String.valueOf(messagePath)))){
            bufferedWriter.write("Someone who suffers from \"anatidaephobia\" believes that somewhere, somehow a duck or goose is constantly watching them. \n");
            bufferedWriter.write("Elephants sing to each other, but their songs are in a frequency too low for humans to hear.\n");
            bufferedWriter.write("Raccoons have four times more sensory cells in their paws than most mammals. This allows them to \"see\" with their hands and get images of the object they touch without even looking at them.\n");
        } catch (IOException e){
            e.getStackTrace();
            System.out.println(e.getMessage());
        }

        try (BufferedReader bufferedReader= new BufferedReader(new FileReader(String.valueOf(messagePath)))){
            String line;
            while ((line = bufferedReader.readLine())!= null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        RedPanda gimli = new RedPanda("Gimli", false);

        try(ObjectOutputStream objectOutputStream= new ObjectOutputStream(new FileOutputStream(String.valueOf(animalPath)))){
            objectOutputStream.writeObject(gimli);
        } catch (IOException e) {
            e.getStackTrace();

        }

        try(ObjectInputStream objectInputStream= new ObjectInputStream(new FileInputStream(String.valueOf(animalPath)))){
            RedPanda redPanda = (RedPanda) objectInputStream.readObject();
            System.out.println(redPanda);
        } catch (IOException | ClassNotFoundException e) {
            e.getStackTrace();

        }

    }
}
