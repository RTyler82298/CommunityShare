public class NotifyPoster {

    public static void main(String[] args) {
        String searchParam = "Hammer"; //In real version this will be set by input from the app

        System.out.println(DBUtils.getPosts(searchParam));


        //In Final Version user will tap on of the displayed results on their app, which will run the next few lines based on their selection


        String postersEmail = DBUtils.getPosterEmail(DBUtils.getPosterUsername(11));

        System.out.println("This is the email that will be informed of the contact: " + postersEmail);



        //Mail.sendMail(postersEmail,searchParam, "Test", "Test", "Test");

    }
}




