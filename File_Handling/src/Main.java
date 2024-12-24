import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello and welcome!");

        // 1. listing all files
//        Path currentDirectory = Paths.get(".");
//        try (Stream<Path> paths = Files.list(currentDirectory)) {
//            paths.forEach(System.out::println);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        // listing recursively with depth
//        try (Stream<Path> paths = Files.walk(currentDirectory, 4)) {
//            paths.forEach(System.out::println);
//            Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".xml");
////            paths.filter(predicate).forEach(System.out::println);
//            BiPredicate<Path, BasicFileAttributes> directoryMatcherBiPredicate = (path, attributes) -> attributes.isDirectory();
//            Files.find(currentDirectory, 1, directoryMatcherBiPredicate).forEach(System.out::println);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        // reading files
        Path pathFile = Paths.get("./src/resources/Data.txt");
        List<String> lines = Files.readAllLines(pathFile);
        System.out.println(lines);

        Files.lines(pathFile).map(String::toLowerCase).forEach(System.out::println);

        //writing to file
        List<String> writeList = List.of(" of ", "file ", "handling ");
        Files.write(pathFile, writeList, StandardOpenOption.APPEND);
        Files.write(pathFile, "!!".getBytes(), StandardOpenOption.APPEND);

    }
}