package com.company;
import java.util.Scanner;

public class PasswordTable {

    private LL<Cust_ID>[] table;
    private int table_size; // elements in the array of LL above

    public PasswordTable(int table_size) {
        this.table_size = table_size;
        table = new LL[table_size];
        for (int i = 0; i < table_size; i++)
        {
            table[i] = new LL<Cust_ID>();
        }
    }
    public PasswordTable(){
        this(100);
    }
    public boolean checkAndInsert(Cust_ID to_insert){ // WE BOOLIN

        int to_be_hashed = hash(to_insert.getID_name(), to_insert.getAssoc_ID_pass());
        System.out.println("HASH:" + to_be_hashed);
        for (int i = 0; i < table[to_be_hashed].getSize(); i++) {
            if (table[to_be_hashed].getAtInd(i).data.getID_name().equals(to_insert.getID_name())) {
                System.out.println("The username " + to_insert.getID_name() + " is already taken. Please try and enter another one.");
                return true;
            }
        }
        this.table[to_be_hashed].insertAtHead(to_insert); // this is to exploit temporal locality. however, if the list gets big enough maybe try inserInOrder() for binary search
        return false;
    }
    private int hash(String s1, String s2)
    {
        int sum = 0;
        for (int i = 0; i < s1.length(); i++)
        {
            char c = s1.charAt(i); sum = sum + (int)c & 0xff;
        }
        for (int i = 0; i < s2.length(); i++)
        {
            char c = s2.charAt(i); sum = sum + (int)c & 0xff;
        }
        return sum % this.table_size;
    }
    public String toString(){
        String ret_string = "";
        for(int i = 0; i < this.table_size; i++){
            if(this.table[i].isEmpty() == 0) // if the list at index i aint empty
                ret_string += this.table[i].toString();
        }
        return ret_string;
    }
    public static void main(String[] args) {

        PasswordTable loginTable = new PasswordTable();
        Scanner user_input = new Scanner(System.in);
        Cust_ID login_Entry;


        for(int i = 0; i < 3; i++) {

            System.out.println("Username>");
            String username = user_input.nextLine();

            System.out.println("\nPassword>");
            String pass = user_input.nextLine();

            login_Entry = new Cust_ID(username, pass);

            while (loginTable.checkAndInsert(login_Entry)) {

                System.out.println("\nUsername>>");
                username = user_input.nextLine();

                System.out.println("\nPassword>>");
                pass = user_input.nextLine();

                login_Entry = new Cust_ID(username, pass);
                System.out.println(login_Entry.toString());
            }
        }
        System.out.println(loginTable.toString());
    }
}