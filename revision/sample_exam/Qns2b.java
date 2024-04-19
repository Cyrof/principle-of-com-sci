
class Qns2b {

    public static void partI(String s1, String s2){
        if(s1.length() > s2.length()){
            System.out.println(s1 + " is longer");
        } else {
            System.out.println(s2 + " is longer");
        }
    }

    public static void partII(String s1, String s2){
        System.out.println(s1.charAt(s1.length()-2) + "" + s1.charAt(s1.length()-1));
    }

    public static void sortString(String s){
        char[] list = s.toCharArray();
        for (int i=0; i<list.length; i++){
            for(int j=i+1; j<list.length; j++){
                if (list[i] > list[j]){
                    char temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        String temp = "";
        for (char c : list){
            temp = temp.concat(String.format("%c", c));
        }
        System.out.println(temp);
    }

    public static void partIII(String s1, String s2){
        sortString(s1);
        sortString(s2);
    }

    public static void partIV(String s1, String s2){
        
    }

    public static void main(String[] args){
        String s1 = "random";
        String s2 = "randomstuff";

        System.out.println("Part I");
        partI(s1,s2);
        System.out.println("Part II");
        partII(s1,s2);
        System.out.println("Part III");
        partIII(s1,s2);
    }
}