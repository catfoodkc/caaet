fpackage caetviewer;
import java.io.IOException;
import java.util.*;

public class Caetviewer {
    ArrayList<String> text = new ArrayList<String>();
    int line;
    Scanner sc = new Scanner(System.in);

    // constructor
    public Caetviewer(){ 
        Input i = new Input();
        text = i.getInputText();
        line = 0;
    }

    public int getLine(){
        return line;
    }

    public void start(){
        System.out.println(". . . welcome to. . .\n. . . the call of cthulhu. . .");
        System.out.println(". . . [s]tart\n. . . [c]ontinue");
        
        char startOption = sc.next().charAt(0);

        if(startOption == 'c'){
            System.out.println("from which page . . . ?");
            int choice = sc.nextInt() - 1;

            if(choice < text.size()){
                printing(choice);
            }
            else{
                printing(0);
            }
        }
        else{
            printing(0);
        }
    }

    /*This function clears the command line which makes the whole thing prettier
    I adapted this from a few sources, primarily from StackOVerflow user Muhammad Gul*/
    private static void clearViewer() {
    try {
        if (System.getProperty("os.name").contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else {
            System.out.print("\033\143");
            System.out.flush();
        }
    } catch (IOException | InterruptedException ex) {}
}

    private static void endView(){
        clearViewer();
        System.out.println(". . . end of text . . .");
        System.exit(0);
    }

    private void helpPrint(int line){
        clearViewer();
        System.out.println(" . . .page " + (line+1) + " . . .");
        System.out.println(text.get(line));
    }

    // This function is ugly & broken i'll unfuck it in the next release
    private void printing(int line){
        clearViewer();
        boolean switchy = false; // im terrible at var names
        helpPrint(line);

        do{
            System.out.print(". . . [p]revious / [n]ext / [q]uit > ");
            char option = sc.next().charAt(0);

            if(option == 'n'){
               switchy = true; 
               line++;
               if(line < text.size()){
                    helpPrint(line);
               }
               else{
                    endView();
               }
            }
            else if(option == 'p'){
                switchy = true;
                if(line > 0){
                    line--;
                    helpPrint(line);
                }
                else{
                    System.out.println(". . . this is the first page. . .");
                    switchy = true;
                }
            }

            else if(option == 'q'){
                clearViewer();
                System.exit(0);
            }

            else{
                switchy = false;
            }

        } while(switchy);
    }
}
