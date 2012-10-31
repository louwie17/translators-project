import java.util.HashMap


public class table-driven-grammer
{
  public static void main(String[] args)
  {
    
  }

  private static HashMap<String,Integer> tableRules = new HashMap<String, Integer>;

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
