package KiemTraDauGio;

import java.util.*;

public class ProductRepository implements IRepository<Product> {

    private List<Product> productList = new ArrayList<>();
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public boolean add(Product item) {
        if (item == null || item.getId() == null) {
            return false;
        }
        if (productMap.containsKey(item.getId())) {
            return false; // tránh trùng id
        }
        productList.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        if (id == null || !productMap.containsKey(id)) {
            return false;
        }
        Product product = productMap.remove(id);
        productList.remove(product);
        return true;
    }

    @Override
    public Product findById(String id) {
        if (id == null) return null;
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public Map<String, Integer> countByType() {
        Map<String, Integer> result = new HashMap<>();
        result.put("Electronic", 0);
        result.put("Food", 0);

        for (Product p : productList) {
            if (p instanceof ElectronicProduct) {
                result.put("Electronic", result.get("Electronic") + 1);
            } else if (p instanceof FoodProduct) {
                result.put("Food", result.get("Food") + 1);
            }
        }
        return result;
    }
}
