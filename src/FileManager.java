import java.io.*;
import java.util.List;

public class FileManager
{
    private final String _filePath;

    public FileManager(String filePath)
    {
        this._filePath = filePath;
    }

    public void writeToFile(List<String> data, boolean append) throws FileManagerException
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(_filePath, append)))
        {
            for (var line : data)
            {
                writer.write(line);
                writer.newLine();
            }
        }
        catch (IOException e)
        {
            throw new FileManagerException("Ошибка при записи в файл", e);
        }
    }

    public List<String> readFromFile() throws FileManagerException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(_filePath)))
        {
            return reader.lines().toList();
        }
        catch (IOException e)
        {
            throw new FileManagerException("Ошибка при чтении файла", e);
        }
    }
}
