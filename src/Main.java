import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {




        LinkedList<String> stringLinkedList = new LinkedList<String>();

        addInOrder(stringLinkedList, "luke");
        addInOrder(stringLinkedList, "bb");
        addInOrder(stringLinkedList, "cc");
        addInOrder(stringLinkedList, "cdd");
        addInOrder(stringLinkedList, "dd");
        addInOrder(stringLinkedList, "ee");
        addInOrder(stringLinkedList, "ss");
        addInOrder(stringLinkedList, "aa");
        addInOrder(stringLinkedList, "sd");
        addInOrder(stringLinkedList, "ase");

        displayLinkedList(stringLinkedList);
        addInOrder(stringLinkedList,"LUKE");
        addInOrder(stringLinkedList,"Eva");
        displayLinkedList(stringLinkedList);

        controlSystem(stringLinkedList);





    }



    public static boolean addInOrder(LinkedList<String> list, String name) {
        name = name.toUpperCase();
        ListIterator<String> stringListIterator = list.listIterator(); // create a list iterator


        while (stringListIterator.hasNext()) {
            int compareTwoString = stringListIterator.next().compareTo(name); // go to next one, compare it
            if (compareTwoString == 0) { // if found the same one
                System.out.println(name + " is already in the list");
                return false; // end
            } else if (compareTwoString > 0) {  // string 1 (b) - string 2 (a)    //   ab - aa
                stringListIterator.previous(); // go bak and add it     ex : 1 2 3
                stringListIterator.add(name);
                return true;

            } else {
                // aa(2) - ab(1)  xx    >    go to next one
            }
        }
        //if no more, need to add to the last one

        stringListIterator.add(name); // add to the last one
        return true;
    }

    public static void displayLinkedList(LinkedList<String> list){
        ListIterator<String> stringListIterator = list.listIterator();
        int count = 1;
        while (stringListIterator.hasNext()){
            System.out.println(count + ".  " + stringListIterator.next());
            count++;
        }
        System.out.println("End of the list");
    }



    public static void menu(){

        System.out.println("-------------");
        System.out.println("1. go to next one");
        System.out.println("2. go to previous");
        System.out.println("3. display all");
        System.out.println("4. add new one");
        System.out.println("0. exit");


    }

    public static void controlSystem ( LinkedList list ){

        Scanner scanner =  new Scanner(System.in);
        boolean flag = true;
        ListIterator<String> stringListIterator = list.listIterator();
        boolean goingForward = true;

        if (list.isEmpty()) {
            System.out.println("No data inside the list");
        }else {
            System.out.println("We are now in " + stringListIterator.next());
        }



        do {
            menu();
            System.out.print("Please enter number : ");
            int select = scanner.nextInt();
            scanner.nextLine();

            switch(select){

                case 1:
                  if (!goingForward){
                      if(stringListIterator.hasNext()){
                          stringListIterator.next();
                      }

                      goingForward = true;
                  }


                    if(stringListIterator.hasNext()) {
                        System.out.println("Now visiting " + stringListIterator.next());
                    } else {
                        System.out.println("End of the list");
                    }
                    break;
                case 2:
                    if (goingForward){
                        if(stringListIterator.hasPrevious()){
                            stringListIterator.previous();
                        }

                        goingForward = false;
                    }

                    if(stringListIterator.hasPrevious()) {
                        System.out.println("Go back to " + stringListIterator.previous());
                    } else {
                        System.out.println("First of the list");
                    }


                    break;
                case 3:
                    displayLinkedList(list);
                    break;

                case 4:
                    System.out.println("Now working yet");
//                    System.out.print("Please Enter One name : ");
//                    String input = scanner.nextLine();
//                    addInOrder(list,input);
//
//                    while (stringListIterator.)
//
//                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong Number");
            }

        }while(flag);



    }




}








