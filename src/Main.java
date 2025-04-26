import java.util.List;

public class Main
{
    public static void main(String[] args) throws FileManagerException
    {
        var fileManager = new FileManager("data.txt");

        var linesToWrite = List.of(
                "String 1",
                "String 2",
                "String 3"
        );

        fileManager.writeToFile(linesToWrite, true);

        fileManager.readFromFile()
                .forEach(System.out::println);
    }
}