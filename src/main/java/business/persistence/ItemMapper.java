package business.persistence;

import business.entities.Item;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {

    Database database;
    public ItemMapper(Database database) {

        this.database = database;
    }

    public List<Item> getAllItems() throws UserException{
        List<Item> itemList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT * FROM item ";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int item_id = rs.getInt("item_id");
                    String item_name = rs.getString("item_name");
                    String description = rs.getString("description");
                    int room_nr = rs.getInt("room_nr");
                    String item_type = rs.getString("item_type");
                    String item_tag = rs.getString("item_tag");
                    Item item = new Item(item_id, item_name, description, room_nr, item_type, item_tag);
                    item.setItem_id(item_id);
                    itemList.add(item);
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }


        return itemList;
    }

    public void createItem(Item item) throws UserException
    {
        try (Connection connection = database.connect())
        {
            //"Oculus Quest 2",	"vr-1",	"VR-headset",212
            String sql = "INSERT INTO item (item_id, item_name, description, room_nr) VALUES (?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, item.getItem_id());
                ps.setString(2, item.getItem_name());
                ps.setString(3, item.getDescription());
                ps.setInt(4, item.getRoom_nr());
                ps.executeUpdate();
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException(ex.getMessage());
        }
    }
}
