package business.entities;

public class Item
{

    public Item(int item_id, String item_name, String description, int room_nr, String item_type, String item_tag) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.description = description;
        this.room_nr=room_nr;
        this.item_type=item_type;
        this.item_tag=item_tag;

    }

    /*public Item(String item_name, String item_type, String item_tag )
    {
        this.item_name=item_name;
        this.item_type=item_type;
        this.item_tag=item_tag;
    }*/

    private int item_id;
    private String item_name;
    private String description;
    private int room_nr;
    private String item_type;
    private String item_tag;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRoom_nr() {
        return room_nr;
    }

    public void setRoom_nr(int room_nr) {
        this.room_nr = room_nr;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_tag() {
        return item_tag;
    }

    public void setItem_tag(String item_tag) {
        this.item_tag = item_tag;
    }
}
