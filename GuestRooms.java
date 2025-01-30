public abstract class GuestRooms {
    public String roomname;
    public String roomID;
    public String ownername;
    public String contact;
    public String details;

    public GuestRooms(){
        roomname = "Somewhere";
        roomID = "RXXX";
        ownername = " ";
        contact = " ";
        details = " ";
    }

    public void Changeowner(String ownername,String contact,String details){
        this.ownername = ownername;
        this.contact = contact;
        this.details = details;
    }
}
