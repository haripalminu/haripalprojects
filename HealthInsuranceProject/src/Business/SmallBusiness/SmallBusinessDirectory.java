/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.SmallBusiness;

import java.util.ArrayList;

/**
 *
 * @author Haripal
 */
public class SmallBusinessDirectory {
    
    ArrayList<SmallBusiness> smallBusinessDirectory;
    
    
    public SmallBusinessDirectory()
    {
        smallBusinessDirectory = new ArrayList<SmallBusiness>();
    }

    public ArrayList<SmallBusiness> getSmallBusinessDirectory() {
        return smallBusinessDirectory;
    }
    
    public SmallBusiness newSmallBusiness()
    {
        SmallBusiness smallBusiness = new SmallBusiness();
        smallBusinessDirectory.add(smallBusiness);
        return smallBusiness;
    }
    
}
