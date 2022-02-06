package caetviewer;
import java.util.*;
import java.io.*;

public class Input {
    ArrayList<String> inputText = new ArrayList<String>();
    Scanner fileScan;

    Input(){
        initInputText(inputText);
    }

    private ArrayList<String> initInputText(ArrayList<String> inputText){
        File input = new File("caetviewer/Input.txt");
        try{
            fileScan = new Scanner(input);
        }
        catch(Exception e){
            System.out.println("oops");
            System.exit(1);

        }

        String tempstr;

        while(fileScan.hasNextLine()){
            tempstr = fileScan.nextLine();
            inputText.add(tempstr);
        }

        return inputText;
    }

    public ArrayList<String> getInputText(){
        return inputText;
    }

}
