/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Haripal
 */
public class TreasuraryEmployeeRole extends Role{
     public TreasuraryEmployeeRole()
    {
        workArea = new TreasuraryEmployeeWorkArea();
    }
}
