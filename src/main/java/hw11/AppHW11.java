package hw11;

public class AppHW11 {
    public static void main(String[] args) {


        String[] partyBasics = {"Decoration", "Guests", "Fun Activity", "Cake", "Gifts"};
        Address tomCruzAddress = new Address("102 palms blvd", "Los Angeles",
                "CA", 90003, true);

        BirthdayParty tomCruz = new BirthdayParty("Tom", "Cruz", 23,
                partyBasics, tomCruzAddress);

        tomCruz.printBirthdayInfo();



        Address office = new Address();
        office.setStreet("100 tomorrow street");

        BirthdayParty jenyLopez = new BirthdayParty();
        jenyLopez.setAge(9);
//        System.out.println(jenyLopez);


        Address joeLopezAddress = new Address("1000 sandy blvd",
                "Los Angeles", "CA", 90003, true);

        BirthdayParty joeLopez = new BirthdayParty("Tom", "Cruz",
                10, partyBasics, tomCruzAddress);

        joeLopez.printBirthdayInfo();








    }
}
