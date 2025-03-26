

public class Main {

    // public static void main(String[] arg) {
    //     System.out.println("Hello world");
    //     for (String str : arg) {
    //         System.out.println(str);
    //     }
    // }

    public static void main(String[] arg) {
        Directory d1 = new Directory("", null);
        Directory d2 = new Directory("MyDir", d1);
        Directory d3 = new Directory("MyOtherDir", d1);

        File f1 = new File("example1.txt", d2, 200);
        File f2 = new File("example2.txt", d2, 250);
        File f3 = new File("example3.txt", d3, 1000);

        // System.out.println(f1.getSize());
        // System.out.println(d1.getSize());
        // System.out.println(d2.getSize());
        // System.out.println(d3.getSize());

        // System.out.println(f1.getPath());
        // System.out.println(f3.toString());
        System.out.println(d1.toString());
        
        // f3.toString();
    }

}

