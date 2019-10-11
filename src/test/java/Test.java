import parser.prepare.LoadCode;

public class Test {
    public static void main(String[] args){
        LoadCode lc=new LoadCode();
        lc.loadCodesByLines("./src/test/policy");
        lc.turnCodesToHashMap();
        lc.printResult();
    }
}
