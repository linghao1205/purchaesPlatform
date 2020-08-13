/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FinanceDepartment;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FinanceRole.CompanyFinanceWorkPlaceJPanel;
import userinterface.FinanceRole.SupplierFinanceWorkPlaceJPanel;

/**
 *
 * @author xia.jia
 */
public class FinanceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Network network, EcoSystem business) {
        if(enterprise.getEnterpriseType().getValue().equals("Company")){
            return new CompanyFinanceWorkPlaceJPanel(userProcessContainer, (FinanceDepartment)organization, enterprise, account, network); 
        }else if(enterprise.getEnterpriseType().getValue().equals("Supplier")){
            return new SupplierFinanceWorkPlaceJPanel(userProcessContainer, (FinanceDepartment)organization, enterprise, account,network);
        }  
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
