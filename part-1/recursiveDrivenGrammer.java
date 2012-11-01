import java.util.Scanner;

public class recursiveGivenGrammer
{
    public static String grammer = "";

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        grammer = in.nextLine();
        system_goal();

        if (grammer.trim().size() == 0)
            System.out.println("Grammer is valid");
        else
            System.out.println("Grammer is invalid");
    }

    public static boolean start(String token)
    {
        if (grammer.trim().startsWith(token.trim()))
            return true;
        else
            return false;
    }

    public static String remove(String token)
    {
        if (start(token))
            return grammer.trim().substring(token.trim().length() - 1,
                    grammer.trim().length() -1);
        else
        {
            System.out.println("Grammer is invalid");
            System.exit(1);
        }

    }

    public static void system_goal()
    {
        if (start("begin"))
        {
            program();
            grammer = remove("$");
        }
    }

    public static void program()
    {
        if (start("begin"))
        {
            grammer = remove("begin");
            statement_list();
            grammer = remove("end");
        }
    }

    public static void statement_list()
    {
        if (start("Id") || start("read") || start("write"))
        {
            statement();
            statement_tail();
        }
    }

    
}
