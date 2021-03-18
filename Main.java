import java.util.ArrayList;

public class Main {
    static ArrayList<String> arrayListstr=new ArrayList<>();

    static ArrayList<Integer> arrayListint=new ArrayList<>();
    static String a="";
    public static void main(String[] args){
        a=args[0];

        readFile readFile=new readFile();


        readFile.openFile();
        readFile.readFile();

        arrayListint=readFile.fileArrayInt;
        arrayListstr=readFile.fileArrayString;

        SplayTree spt = new SplayTree();

       // spt.insert(arrayListint.get(0));
        //spt.preorder();
        for(int i=0;i<arrayListstr.size();i++){

//            /System.out.println(arrayListint.get(i));

            if(arrayListstr.get(i).matches("insert")){
                spt.insert(arrayListint.get(i));

            }else if(arrayListstr.get(i).matches("remove")){
                spt.remove(arrayListint.get(i));


            }else if(arrayListstr.get(i).matches("find")){
                spt.search(arrayListint.get(i));

            }
            //System.out.println(spt.countNodes());
            spt.preorder();
            System.out.println(" ");
        }

        readFile.closeFile();

    }

}
