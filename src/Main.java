import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/*
*  MAIN WILL HANDLE REWARD PROGRAM
*/
public class Main {
    // DEFINE SCANNER OBJECT OBE USED BY ALL FUNCTIONS WITHIN CLASS
    static Scanner scan = new Scanner(System.in);
    static ArrayList<String[]> data = getData();
    static String currentYear = data.get(data.size() - 1)[0].substring(0, 4);
    /*
     * 
     */
    public static void main(String[] args) {
        // DEFINE OPTION
        int option;

        // DEFINE MEMEBER ID TO RETRIEVE INFORMATION FROM
        // DEFINE menuPrompt
        String menuPrompt = "Enter the corresponding digits for your queries:\n" +
                "0. to quit: \n" +
                "1. Reward Tier Information\n" +
                "2. Member Queries" +
                "\n";

        do {
            // DISPLAY MENU
            System.out.println(menuPrompt);

            // GET MENU INPUT
            option = scan.nextInt();

            // PROCESS THE OPTION THAT THE USER WANTS
            processOption(option);
        } while (option != 0);

    }

    public static void processOption(int option) {
        int desiredOption;
        String desiredTierInformation;
        int desiredMemberID;
        String desiredMemberIDInformation;

        // DEFINE OPTION 1 PROMPTS
        String promptTierOptions = "Memberships Options: \n"
                + "1 - Gold \n"
                + "2 - Platinum\n"
                + "3 - Platinum Pro\n"
                + "4 - Executive Platinum\n"
                + "5 - Super Executive Platinum\n"
                + "0 - quit";

        // PROCESSING
        String promptMemberOptions = "1. Get Total Miles For Current Year \n" +
                "2. Get Total Miles \n" +
                "3. Get Join Date \n" +
                "4. Get Current Tier \n" +
                "0. To quit";

        // IF 1 IS ENTERED, PROVIDE TIER INFORMATION
        if (option == 1) {
            // DISPLAY PROMPT
            System.out.println(promptTierOptions);
            // GET INPUT
            desiredOption = scan.nextInt();
            // DISPLAY TIER INFO
            desiredTierInformation = getTierInformation(desiredOption);
            System.out.println(desiredTierInformation);
        }

        // IF OPTION 2 IS SELECTED, PROCESS INVIDUAL MEMBER INFO
        if (option == 2) {
            // ASK USER FOR MEMBER ID
            System.out.println("Input Member ID to query:");

            // GET MEMBER ID
            desiredMemberID = scan.nextInt();

            // PROMPT USER OPTIONS FOR EACH MEMBER
            System.out.println("Input Desired Query:");
            System.out.println(promptMemberOptions);

            // GET INPUT
            desiredOption = scan.nextInt();

            // GET DESIRED INFO
            desiredMemberIDInformation = getMemberIDInformation(desiredMemberID, desiredOption);

            System.out.println("\n" + desiredMemberIDInformation);

        }

    }

    public static String getTierInformation(int desiredTierInt) {
        switch (desiredTierInt) {
            case 1:
                return new String(
                        "25,000 miles. Gold passengers get special perks such as a seat to sit in during the flight.");

            case 2:
                return new String("50,000 miles. Platinum passengers get complementary upgrades to padded seats.");

            case 3:
                return new String("75,000 miles. Platinum Pro is a special sub-tier of Platinum, in which the"
                        + " padded seats include arm rests");

            case 4:
                return new String("100,000 miles. Executive Platinum passengers enjoy perks such as" +
                        " complementary upgrades from the cargo hold to main cabin.");
            case 5:
                return new String("150,000 miles. Super Executive Platinum is a special sub-tier of Executive Platinum,"
                        +
                        " reserved for the most loyal passengers. To save costs, airline" +
                        " management decided to eliminate the position of co-pilot, instead opting to reserve the"
                        + "co-pilot’s seat for Super Executive Platinum passengers.");
            default:
                return new String("Incorrect option. Please try again.");

        }
    }

    public static String getMemberIDInformation(int desiredMemberID, int desiredOption) {
        /*
        * "1. Get Total Miles For Current Year \n" +
        "2. Get Total Miles \n" +
        "3. Get Join Date \n" +
        "4. Get Current Tier \n" +
        "0. To quit";
        */
        String date = "";
        String year = "";
        int memberID;
        int miles = 0;
        int totalMiles = 0;
        switch (desiredOption) {
            
            // GET TOTAL MILES CURRENT YEAR
            case 1:
                totalMiles = 0;
                for(int i=0; i<data.size(); i++){
                    date = data.get(i)[0];
                    year = data.get(i)[0].substring(0, 4);
                    memberID = Integer.parseInt(data.get(i)[1]);
                    miles = Integer.parseInt(data.get(i)[2]);

                    // 0 == date
                    // 1 == memberid
                    // 2 == miles
                    if(memberID == desiredMemberID){
                        if(currentYear.equals(year)) {
                            totalMiles += miles;
                        }
                    }
                }
                return String.valueOf("TOTAL MILES IN "+ currentYear + " FOR "  + desiredMemberID + " : " + totalMiles);
            // GET TOTAL MILES
            case 2:
                totalMiles = 0;
                for(int i=0; i<data.size(); i++){
                    date = data.get(i)[0];
                    year = data.get(i)[0].substring(0, 4);
                    memberID = Integer.parseInt(data.get(i)[1]);
                    miles = Integer.parseInt(data.get(i)[2]);

                    // 0 == date
                    // 1 == memberid
                    // 2 == miles
                    if(memberID == desiredMemberID){
                        totalMiles += miles;
                    }
                }

                return String.valueOf("TOTAL MILES FOR " + desiredMemberID + " : " + totalMiles);
            case 3:

                for(int i=0; i<data.size(); i++){
                    date = data.get(i)[0];
                    memberID = Integer.parseInt(data.get(i)[1]);
                    miles = Integer.parseInt(data.get(i)[2]);

                    // 0 == date
                    // 1 == memberid
                    // 2 == miles
                    if(memberID == desiredMemberID){
                        return String.valueOf("JOIN DATE FOR " + desiredMemberID + " : " + date);
                    }
                }

            case 4:
                    for(int i=0; i<data.size(); i++){
                        date = data.get(i)[0];
                        year = data.get(i)[0].substring(0, 4);
                        memberID = Integer.parseInt(data.get(i)[1]);
                        miles = Integer.parseInt(data.get(i)[2]);
                        String yearToAssess = String.valueOf(Integer.parseInt(currentYear) - 1);
                        // 0 == date
                        // 1 == memberid
                        // 2 == miles
                        if(memberID == desiredMemberID){
                            if(year.equals(yearToAssess)){
                                totalMiles += miles;
                            }
                        }
                    }
                return String.valueOf("CURRENT TIER FOR " + desiredMemberID + " : " + getTierFromMiles(miles));
            default:
                return new String("Incorrect Option.");

        }
    }

    public static String getTierFromMiles(int miles){
        if( 25000 <= miles && miles < 50000){
            return new String("Gold");
        } 
        if( 50000 <= miles && miles < 75000){
            return new String("Platinum");
        } 
        if( 75000 <= miles && miles < 100000){
            return new String("Platinum Pro");
        } 
        if( 100000 <= miles && miles < 150000){
            return new String("Executive Platinum");
        } 
        if(150000 <= miles){
            return new String("Super Executive Platinum");

        }else {
            return new String("NOT A MEMBER");
        }

    }

    public static ArrayList<String[]> getData() {
        // EXAMPLE [["2019-01-01", 101", 875"],[]]
        ArrayList<String[]> data = new ArrayList<String[]>();

        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader("src/input.txt"));
            // DEFINE ROW
            String[] row = new String[3];
            do {
                line = reader.readLine();
                row = line.trim().split(" ");
                data.add(row);
            } while (line != null);

            // SPLIT EACH LINE INTO AN ARRAY OF THREE ELEMENTS
            reader.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        

        return data;
        
    }
    


}