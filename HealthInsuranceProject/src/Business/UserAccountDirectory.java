/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class UserAccountDirectory {
    ArrayList<UserAccount> userDirectory;
    
    public UserAccountDirectory()
    {
        userDirectory = new ArrayList<UserAccount>();
    }
    public UserAccount newUserAccount()
    {
        UserAccount userAccount = new  UserAccount();
        userDirectory.add(userAccount);
        return userAccount;
    }
    public UserAccount authenticate(String userName,String password)
    {
        for(UserAccount ua:userDirectory)
        {
            if(ua.getUserName().equals(userName)&&ua.getPassword().equals(password)&& ua.isStatus())
            {
                return ua;
            }
        }
        return null;
    }

    public ArrayList<UserAccount> getUserDirectory() {
        return userDirectory;
    }
    
}
