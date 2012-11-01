import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class tableDrivenGrammer
{
  
  private static Deque<String> stack = new ArrayDeque<String>();
  private static Deque<String> grammer_stack = new ArrayDeque<String>();
  private static HashMap<String,Integer> tableRules = new HashMap<String, Integer>();

  public static void main(String[] args)
  {
    fillTable();
    System.out.print("Grammer: ");
    Scanner sc = new Scanner(System.in);
    String gram = sc.nextLine();
    Scanner as = new Scanner(gram);
    while (as.hasNext())
        stack.addLast(as.next());
    System.out.println("Grammer is: " + checkGrammer());
  }

  public static boolean checkGrammer()
  {
      boolean valid = true;
    grammer_stack.push("$");
    grammer_stack.push("<program>");
      while(stack.size() > 0 || valid == true)
      {
          if (grammer_stack.size() == 0 || stack.size() == 0)
          {
              valid = false;
              break;
          }
          String a = grammer_stack.peek();
          String b = stack.peek();

          String rule = a + "," + b;
          System.out.println(a + " compare to " +b);  
          if (a.compareTo(b) == 0)
          {
              System.out.println("Match");
              stack.pop();
              grammer_stack.pop();
              continue;
          }
         int useRule = tableRules.get(rule);
        if (useRule >= 1 && useRule <= 22)
            grammer_stack.pop();
        switch (useRule) 
        {
            case 1:
                grammer_stack.push("end");
                grammer_stack.push("<statement list>");
                grammer_stack.push("begin");
                break;
            case 2: 
                grammer_stack.push("<statement tail>");
                grammer_stack.push("<statement>");
                break;
            case 3:
                grammer_stack.push("<statement tail>");
                grammer_stack.push("<statement>");
                break;
            case 4:
                break;
            case 5:
                grammer_stack.push(";");
                grammer_stack.push("<expression>");
                grammer_stack.push("=");
                grammer_stack.push(":");
                grammer_stack.push("Id");
                break;
            case 6:
                grammer_stack.push(";");
                grammer_stack.push(")");
                grammer_stack.push("<id list>");
                grammer_stack.push("(");
                grammer_stack.push("read");
                break;
            case 7:
                grammer_stack.push(";");
                grammer_stack.push(")");
                grammer_stack.push("<expr list>");
                grammer_stack.push("(");
                grammer_stack.push("write");
                break;
            case 8:
                grammer_stack.push("<id tail>");
                grammer_stack.push("Id");
                break;
            case 9:
                grammer_stack.push("<id tail>");
                grammer_stack.push("Id");
                grammer_stack.push(",");
                break;
            case 10:
                break;
            case 11:
                grammer_stack.push("<expr tail>");
                grammer_stack.push("<expression>");
                break;
            case 12:
                grammer_stack.push("<expr tail>");
                grammer_stack.push("<expression>");
                grammer_stack.push(",");
                break;
            case 13:
                break;
            case 14:
                grammer_stack.push("<primary tail>");
                grammer_stack.push("<primary>");
                break;
            case 15:
                grammer_stack.push("<primary tail>");
                grammer_stack.push("<primary>");
                grammer_stack.push("<add op>");
                break;
            case 16:
                break;
            case 17:
                grammer_stack.push(")");
                grammer_stack.push("<expression>");
                grammer_stack.push("(");
                break;
            case 18:
                grammer_stack.push("Id");
                break;
            case 19:
                grammer_stack.push("INTLIT");
                break;
            case 20:
                grammer_stack.push("+");
                break;
            case 21:
                grammer_stack.push("-");
                break;
            default:
                valid = false;
                break;
        }
      }
      if (stack.size() == 0)
          return true;
      else 
          return false;

  }
  
  public static void fillTable()
  {
    tableRules.put("<program>,begin", 1);
    tableRules.put("<statement list>,Id",2);
    tableRules.put("<statement list>,read",2);
    tableRules.put("<statement list>,write",2);
    tableRules.put("<statement tail>,Id",3);
    tableRules.put("<statement tail>,read",3);
    tableRules.put("<statement tail>,write",3);
    tableRules.put("<statement tail>,end",4);
    tableRules.put("<statement>,Id",5);
    tableRules.put("<statement>,read",6);
    tableRules.put("<statement>,write",7);
    tableRules.put("<id list>,Id",8);
    tableRules.put("<id tail>,,",9);
    tableRules.put("<id tail>,)",10);
    tableRules.put("<expr list>,Id",11);
    tableRules.put("<expr list>,INTLIT",11);
    tableRules.put("<expr tail>,,",12);
    tableRules.put("<expr tail>,)",13);
    tableRules.put("<expression>,Id",14);
    tableRules.put("<expression>,INTLIT",14);
    tableRules.put("<primary tail>,,",16);
    tableRules.put("<primary tail>,)",16);
    tableRules.put("<primary tail>,+",15);
    tableRules.put("<primary tail>,-",15);
    tableRules.put("<primary tail>,;",16);
    tableRules.put("<primary tail>,(",17);
    tableRules.put("<primary>,Id",18);
    tableRules.put("<primary>,INTLIT",19);
    tableRules.put("<add op>,+",20);
    tableRules.put("<add op>,-",21);
    tableRules.put("<system goal>,begin",22);  
  }
}
