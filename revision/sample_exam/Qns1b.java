

class Qns1b {

    public static void partI(){
        int counter = 2;
        String numList = "";
        while (true){
            if (counter < 36){
                numList = numList.concat(String.format("%d ", counter));
                counter+=3;  
            }
            else{ 
                break;
            }
        }
        System.out.println(numList);
    }

    public static void partII(){
        int counter = 1;
        String numList = "";
        for (int i=0; i <5; i++){
            for (int j=0; j < counter; j++){
                numList = numList.concat(String.format("%d ", i));
            }
            counter++;
        }
        System.out.println(numList);
    }

    public static void partIII(){
        int counter = 3;
        int number = 1;
        while (true){
            if (number <= 100){
                System.out.println(number);
                number += counter;
                counter += 2;
            }
            else{
                break;
            }
        }
    }

    public static void main(String[] args){
        // partI();
        // partII();
        partIII();
    }
}