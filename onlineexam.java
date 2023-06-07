import java.awt.*;
import javax.swing.*;
import java.util.*;
class Exam 
{
    public static Scanner sc = new Scanner(System.in);
    public static int rt;
    public static String[] questions = {
            "Which of the following is not a primitive data type in Java?\t   \n   a) int\n   b) boolean\n   c) float\n   d) string",
            "What is the correct syntax to declare an array in Java?\t   \n   a) int[] arr;\n   b) array arr[];\n   c) arr[] = new int[];\n   d) int arr.",
            "Which of the following is true about inheritance in Java?\t   \n   a) Multiple inheritance is supported\n   b) public methods can be inherited\n   c) All classes must inherit from the Object class\n   d) Constructors can be inherited",
            "Which keyword is used to inherit a class in Java?\t   \n   a) extends\n   b) inherits\n   c) implements\n   d) superclass",
            "Which loop is guaranteed to execute at least once in Java?\t  \n   a) for loop\n   b) while loop\n   c) do-while loop\n   d) break loop",
            "Which of the following is not a wrapper class in Java?\t \n  a) Integer\n  b) Float\n  c) String\n  d) Boolean",
            "What is the purpose of a constructor in Java?\t \n a) To create multiple instances of a class.\n b) To provide access to private class members.\n c) To initialize the state of an object.\n d) To execute a block of code repeatedly.",
            "Which keyword is used to create an object in Java?\t \n a) this\n b) new\n c) extends\n d) implements",
            "Which keyword is used to break out of a loop in Java?\t \n a) break\n b) exit\n c) stop\n d) quit",
            "Which keyword is used to refer to the current instance of a class in Java?\t \n a) this\n b) that\n c) self\n d) object",
    };
    public static int currentQuestionIndex;
    public static String[] answers;
    public static int questionCount = 10;
    public static final int questionTimeLimit = 5; // seconds
    public static final int totalExamTime = 60; // Total exam duration in seconds

    public static void startExam() 
    {
        answers = new String[questionCount];
        instructions();
        startTimer();
        displayMCQs();
        TimerOrAutoSubmit(answers,sc);
        closeExam();
    }

    public static void instructions()
    {
        System.out.println("********************* Read The Instructions ****************************");
        System.out.println("This exam consists of 10 multiple-choice questions based on Java basics.");
        System.out.println("Each question has four options (A, B, C, and D), out of which only one option is correct.");
        System.out.println("You have a total of 1 minute 20 secs to complete the exam.");
        System.out.println("Spend the first 20 secs to read the Instructions.");
        System.out.println("Once the time is up, stop answering and wait for the Result");
        System.out.println("************************************************************************");

    }

    public static void displayMCQs() 
    {
        System.out.println("--- MCQ Section ---");
        System.out.println("*************************");
        for (int i = 0; i < questions.length; i++) {
            System.out.println((i + 1) + "] " + questions[i]);
            System.out.print("Your answer: ");
            String answer = sc.next();
            answers[i] = answer;
        }
        System.out.println("\n--- End of MCQ Section ---");
    }

    public static void startTimer() 
    {
        rt = totalExamTime;
        JFrame tf = new JFrame("Exam Timer CountDown");
        tf.setSize(200, 100);
        tf.setLocationRelativeTo(null);
        JLabel tl = new JLabel();
        tl.setHorizontalAlignment(SwingConstants.CENTER);
        tf.add(tl);
        tf.setVisible(true);
        Thread timerThread = new Thread(() -> {
            while (rt >= 0) {
                EventQueue.invokeLater(() -> {
                    tl.setText("Exam Timer\n");
                    tl.setText("Time Remaining: " + rt + " seconds");
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rt--;
            }
            tf.dispose();
            closeExam();
        });
        timerThread.start();
    }
    

    public static void TimerOrAutoSubmit(String[] answers,Scanner sc)
    {
        System.out.println("\nIf the Exam is Done! Press 'S' to submit your exam anytime.");
        long st_time = System.currentTimeMillis();
        while (rt > 0) {
            String input = sc.nextLine();
            if (input.equals("S") || input.equals("s")) {
                long end_time = System.currentTimeMillis();
                int elapsedTime = (int) ((end_time - st_time) / 1000);
                rt -= elapsedTime;
                closeExam();
                break;
            }
            else
            {
                onlineexam.menu();
            }
        }
    }

    public static void closeExam() 
    {
        System.out.println("\n--- Exam Summary ---");
        for (int i = 0; i < questionCount; i++) 
        {
            System.out.println("Question " + (i + 1) + ": Your answer - " + answers[i]);
        }
        System.out.println("The Correct answers are [d,a,b,a,c,c,c,b,a,a]");
        System.out.println("Exam session closed.");
        int score = calculateScore();
        System.out.println("\nYour Score: " + score + "/" + questionCount);
        System.out.println("Total Questions: " + questions.length);
        System.out.println("Correct Answers: " + score); 

        if (score == questionCount) 
        {
            System.out.println("Congratulations! You scored 100%.");
        } else if (score >= questionCount / 2) {
            System.out.println("Well done! You passed the exam.");
        } else 
        {
            System.out.println("Sorry! You did not pass the exam.");
        }
        System.out.println("**********************************");

    }

    public static int calculateScore() 
    {
        int s=0;
        String[] correctAnswers = {"d","a","b","a","c","c","c","b","a","a"};
        for (int i = 0; i < questionCount; i++) 
        {
            if(null== answers[i])
            {
                s=s+0;

            }
            else if (answers[i].equals(correctAnswers[i])) 
            {
                s=s+1;
            }
            else
            {

                s=s+0;
            }
        }
        return s;
}
}

class onlineexam{
    static String username="varshith";
    static String password="9684";
    static String  p;
    static String  q;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String x;
        System.out.println("**********************************");
        System.out.println("Welcome to the Online Exam System!");
        System.out.println("**********************************");
        System.out.println("Do you want to login to the Portal!(Y/y OR N/n)");
        x = sc.next();
        if (x.equals("y") || x.equals("Y") ) {
            login();
            if (username.equals(p) && password.equals(q)) {
                System.out.println("Authentication successful...");
                menu();
            }
            else
            {
                System.out.println("Invalid Credentials...");
                System.out.println("Authentication Failed");

            }
        } else if (x.equals("n") || x.equals("N")) {
            System.out.println("OK...Thank you for visiting the page");
        } else {
            System.out.println("Invalid Letterv");
        }
    }

    public static void menu() 
    {

        int ch;
        while(true)
        {
        System.out.println("\nSelect an option:");
        System.out.println("1. Update Profile and Password");
        System.out.println("2. Start Exam");
        System.out.println("3. Logout");
        ch = sc.nextInt();
            switch (ch) 
            {
                case 1:
                    update();
                    break;
                case 2:
                    startExam();
                    break;
                case 3:
                    logout();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        }
    }

    public static void login() 
    {
        System.out.println("For trial Enter user:varshith and pass:9684");
        System.out.print("Username: ");
         p = sc.next();
        System.out.print("Password: ");
         q = sc.next();
    }

    public static void update() 
    {
        String n;
        System.out.println("Do you want to update your username and password[Enter 'Y/y' if yes and 'N/n' if no]");
        n = sc.next();
        if (n.equals("y") || n.equals("Y")) {
            System.out.print("Enter new username: ");
            String un = sc.next();
            System.out.print("Enter new password: ");
            String pd = sc.next();
            username = un;
            password = pd;
            System.out.println("Profile and password updated successfully!");
        } else if (n.equals("n") || n.equals("N"))
        {
            System.out.println("Profile and password are the same as before!");
        } else {
            System.out.println("Invalid input!");
        }
        menu();
    }

    public static void logout() {
        username = null;
        password = null;
        System.out.println("Logged out successfully!");
        System.exit(0);
    }

    public static void startExam() {
        Exam.startExam();
        menu();
    }
}

