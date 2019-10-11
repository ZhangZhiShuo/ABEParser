package parser.prepare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoadCode {
    public ArrayList<String> getCodesByLines() {
        return codesByLines;
    }

    private ArrayList<String> codesByLines=new ArrayList<>();
    private HashMap<String,String> kv=new HashMap<>();
    private Pattern pattern=Pattern.compile("^\\s*([A-Z_a-z][A-Z_a-z0-9]*)\\s*:\\s*(.*)\\s*$");
    public void loadCodesByLines(String fileName){
        try(BufferedReader br=new BufferedReader(new FileReader(fileName))){
            String buf=null;
            while((buf=br.readLine())!=null){
                System.out.println(buf);
                codesByLines.add(buf);
            }
        }

            catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public void turnCodesToHashMap(){
        System.Logger logger=System.getLogger("logger");
        //loadCodesByLines(fileName);
        for(int i=0;i<codesByLines.size();i++){
            String line=codesByLines.get(i);
            Matcher matcher=pattern.matcher(line);
            if(!matcher.matches()){
                 logger.log(System.Logger.Level.ERROR,"Error in the number "+i+" line");
                 return;
            }
            String attributeName=matcher.group(1);
//            System.out.println(attributeName);
            String attributeLimits=matcher.group(2);
//            System.out.println(attributeLimits);
            kv.put(attributeName,attributeLimits);
        }
    }
    public void printResult(){
        System.out.println(kv);
    }

}
