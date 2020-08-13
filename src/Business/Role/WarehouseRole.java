/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.Warehouse;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.WarehouseRole.CompanyWarehouseWorkPlaceJPanel;
import userinterface.WarehouseRole.SupplierWarehouseJPanel;

/**
 *
 * @author xia.jia
 */
public class WarehouseRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        if (enterprise.getEnterpriseType().getValue().equals("Company")){
            return new CompanyWarehouseWorkPlaceJPanel(userProcessContainer, account, (Warehouse)organization, enterprise);
        }
        return new SupplierWarehouseJPanel(userProcessContainer, (Warehouse)organization, enterprise, account);
    }
    
}
