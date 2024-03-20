public class ContactManager {
    private Contact[] contacts;

    

    public ContactManager(Contact[] contacts){
        this.contacts = new Contact[contacts.length];
        // iterate the array and do a deep copy of each element
        for (int i = 0; i < this.contacts.length; i++) {
            this.contacts[i] = new Contact(contacts[i]);
        }
    }

    public Contact getContact(int index){
        Contact copyContact = new Contact(this.contacts[index]);
        return copyContact;
    }

    public void setContact(Contact contact, int index){
        this.contacts[index] = new Contact(contact);
    }

    
}
