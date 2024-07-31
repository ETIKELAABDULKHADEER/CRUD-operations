package khadeer;

//public class ItemManager {
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	public class ItemManager {
	    private List<Item> items;

	   public ItemManager() {
	        items = new ArrayList<>();
	    }

	    // Create a new item
	    public void addItem(int id, String name) {
	        items.add(new Item(id, name));
	        System.out.println("Added: " + name);
	    }

	    // Read all items
	    public void listItems() {
	        if (items.isEmpty()) {
	            System.out.println("No items available.");
	        } else {
	            for (Item item : items) {
	                System.out.println(item);
	            }
	        }
	    }

	    // Update an item by id
	    public void updateItem(int id, String newName) {
	        Optional<Item> itemToUpdate = items.stream().filter(item -> item.getId() == id).findFirst();
	        if (itemToUpdate.isPresent()) {
	            itemToUpdate.get().setName(newName);
	            System.out.println("Updated item to: " + newName);
	        } else {
	            System.out.println("Item not found.");
	        }
	    }

	    // Delete an item by id
	    public void deleteItem(int id) {
	        boolean removed = items.removeIf(item -> item.getId() == id);
	        if (removed) {
	            System.out.println("Deleted item with id: " + id);
	        } else {
	            System.out.println("Item not found.");
	        }
	    }

	    public static void main(String[] args) {
	        ItemManager manager = new ItemManager();

	        // Create items
	        manager.addItem(1, "Item1");
	        manager.addItem(2, "Item2");
	        manager.addItem(3, "Item3");

	        // Read items
	        System.out.println("Items list:");
	        manager.listItems();

	        // Update item
	        manager.updateItem(2, "UpdatedItem2");

	        // Read items after update
	        System.out.println("Items list after update:");
	        manager.listItems();

	        // Delete item
	        manager.deleteItem(3);

	        // Read items after deletion
	        System.out.println("Items list after deletion:");
	        manager.listItems();
	    }
	}


