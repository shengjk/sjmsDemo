package msxf.java;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * Created by 小省 .
 */
public class DirList {
    public static void main(String[] args) {
        File path =new File(".");
        String[] list;
        if(args.length==0){
            path.list();
        }else{
            list=path.list(new DirFIlter(args[0]));
        }
    }
}
class DirFIlter implements FilenameFilter{
    private Pattern pattern;

    public DirFIlter(String  regex) {
        pattern=Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}

