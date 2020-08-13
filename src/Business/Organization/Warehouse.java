/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.WarehouseRole;
import Business.Role.Role;
import java.util.ArrayList;

import Business.WorkQueue.Material;
import Business.WorkQueue.Storage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author raunak
 */
public class Warehouse extends Organization{
    
    private List<Storage> inventory;
    
    public Warehouse() {
        super(Organization.Type.Warehouse.getValue());
        inventory = new LinkedList<>();
    }
    
    public List<Storage> getInventory() {
        return inventory;
    }
    
    public void setInventory(List<Storage> inventory) {
        this.inventory = inventory;
    }
    
    public Storage searchStorage(String name){
        for(Storage storage:inventory){
            if(storage.getMaterial().getProductionModel().equals(name)){
                return storage;
            }
        }
        return null;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WarehouseRole());
        return roles;
    }  
    
}