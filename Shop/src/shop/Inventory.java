package shop;
import java.util.*;

public abstract class Inventory<T> {
	private HashMap<T, Integer> items;
	
	public Integer checkStock(T item) {
		Integer stock = items.get(item);
		if (stock == null) return 0;
		return stock;
	}
	
	public void addItem(T item) {
		Integer prevStock = checkStock(item);
		if (prevStock == 0) items.put(item, 1);
		else items.put(item, prevStock + 1);
	}
	
	public boolean removeItem(T item) {
		Integer prevStock = checkStock(item);
		if (prevStock <= 0) return false;
		items.put(item, prevStock - 1);
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(items);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(items, other.items);
	}
	
}