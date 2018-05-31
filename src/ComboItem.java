public class ComboItem extends Object {

    //ID
    public int ID;
    public String text;

    ComboItem(String msg, int id){
        this.ID = id;
        this.text = msg;
    }

    @Override
    public String toString()
    {
        return text;
    }

    public int getID(){
        return ID;
    }

    public String getText(){
        return text;
    }
}
