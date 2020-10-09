
package kontrol;


public class LoginSession {
   private static String username;
   public static String getUsername()
           {
               return username;
           }
   public static void setUsername(String name)
           {
               LoginSession.username=name;
           }
}
