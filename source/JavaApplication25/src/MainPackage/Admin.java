package MainPackage;
public class Admin {
    private final static String[]admin={"mkharto","jerrykr","salmahnf"};
    private final static String[]paskey={"0906","",""};
    public boolean login(String a, String b){
        boolean c;
        if(a.equals(admin[0])&&b.equals(paskey[0]))c=true;
        else if(a.equals(admin[1])&&b.equals(paskey[1]))c=true;
        else if (a.equals(admin[2])&&b.equals(paskey[2]))c=true;
        else c=false;
        return c;
    }
}
