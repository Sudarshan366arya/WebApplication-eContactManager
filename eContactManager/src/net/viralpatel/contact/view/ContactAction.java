package net.viralpatel.contact.view;
 
import java.util.List;
import net.viralpatel.contact.controller.ContactManager;
import net.viralpatel.contact.model.Contact;
import com.opensymphony.xwork2.ActionSupport;
 
 public class ContactAction extends ActionSupport {
 
    private static final long serialVersionUID = 9149826260758390091L;
    private Contact contact;
    private List<Contact> contactList;
    private int id;
    private ContactManager contactManager;
 
    public ContactAction() {
        contactManager = new ContactManager();
    }
 
    public String execute() {
        this.contactList = contactManager.list();
        System.out.println("execute called");
        return SUCCESS;
    }
 
    public String add() {
        System.out.println(getContact());
        try {
        	if(getContact().getId()==0){
        		 contactManager.add(getContact());
        	}else{
        		 contactManager.updatedone(getContact());
        	}
           } catch (Exception e) {
            e.printStackTrace();
        }
        this.contactList = contactManager.list();
        return SUCCESS;
    }
    public String view() {
        System.out.println(getContact());
        this.contactList = contactManager.list();
        return SUCCESS;
    }
    public String search() {
        System.out.println("-----------------Check----------->>>>>>>>>>>>>>>>>>"+getContact().getFirstname());
        Contact cont=new Contact();
        cont=getContact();
        this.contactList = contactManager.search(cont.getFirstname(),cont.getLastname(),cont.getEmailId());
        return SUCCESS;
    }
 
    public String delete() {
        contactManager.delete(getId());
        return SUCCESS;
    }
    public String update() {
    
    return SUCCESS;
    }
    public String updatedone() {
    	 contactManager.updatedone(getContact());
         return SUCCESS;
        }
    
    public Contact getContact() {
        return contact;
    }
    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public List<Contact> getContactList() {
        return contactList;
    }
 
    public void setContactList(List<Contact> contactsList) {
        this.contactList = contactsList;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
   
    public Contact getContactedit(){
        return contactManager.update(getId());   
        }
}