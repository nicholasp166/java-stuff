package webs;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class filescript {

    public static void main(String[] args) throws FileNotFoundException{

        try{
            File fileObj = new File(args[0]);
            if(fileObj.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File exists.");
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }

        try{
            FileWriter myWriter = new  FileWriter(args[0]);
            BufferedWriter bw = new BufferedWriter(myWriter);
            String htmlLine = ("<!DOCTYPE html>\n<html lang=\"en\">\n\t<head>\n\t\t<meta charset=\"UTF-8\">\n\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n\t\t<title>website</title>\n\t\t<link rel=\"stylesheet\" href=\"./style.css\">\n\t</head>\n\t<body>\n\t\t<main>\n\t\t\t<h1>Welcome to My Website</h1>\n\t\t</main>\n\t</body>\n</html>");
            String[] words = htmlLine.split("|");

            for (String word:words){
                myWriter.write(word);
                bw.newLine();
            }
            
            bw.close();
            System.out.println("Wrote to file.");
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }
}
