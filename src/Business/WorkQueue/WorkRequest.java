/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private Material material;
    private String CompanyName;
    private int DeliveryNumber;
    private int Quantity;
    

    public WorkRequest(Material material, String CompanyName, int DeliveryNumber, int Quantity) {
        this.material = material;
        this.CompanyName = CompanyName;
        this.DeliveryNumber = DeliveryNumber;
        this.Quantity = Quantity;
    }

   
    public WorkRequest(){
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
        
    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public int getDeliveryNumber() {
        return DeliveryNumber;
    }

    public void setDeliveryNumber(int DeliveryNumber) {
        this.DeliveryNumber = DeliveryNumber;
    }
  
    @Override
    public String toString(){
        return String.valueOf(this.getDeliveryNumber());
    }
}
