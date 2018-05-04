package com.company;

import com.sun.xml.internal.bind.v2.TODO;
import java.util.List;
import java.util.ArrayList;

public class Params {
    private final List<String> err;
    private String InputFileName;
    private String OutFileName;

    private Params() {
        err = new ArrayList<>();
    }

    public List<String> getErrors() {
        return err;
    }

    private void checkInputFileName (String arg){
        if (arg == null || "".equals(arg)) {
            err.add("Error input file name");
            return;
        }
        InputFileName = arg;
    }
    private void checkOutFileName (String arg){
        if (arg == null || "".equals(arg)) {
            err.add("Error output file name");
            return;
        }
        OutFileName = arg;
    }

    public String getInputFileName() {
        return InputFileName;
    }

    public String getOutFileName() {
        return OutFileName;
    }

    public boolean valid(){
        return (err.isEmpty());
    }

    public static Params parseArgs (String[] args){
        Params params = new Params();
        // в командной строке два входных файла,
        if (args.length != 2) {
            params.err.add("Input data is not enuouf");
            return params;
        }
        params.checkInputFileName(args[0]);
        params.checkOutFileName(args[1]);

        return params;
    }
}
