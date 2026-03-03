package MiniProject.main.service;

import MiniProject.main.model.Pet;

public class PetManager extends GenericManager<Pet> {

    public boolean addPet(Pet pet) {

        if (pet.getId().isBlank()) {
            System.out.println("ID không được để trống!");
            return false;
        }

        if (findById(pet.getId()) != null) {
            System.out.println("ID đã tồn tại!");
            return false;
        }

        if (pet.getPrice() <= 0) {
            System.out.println("Giá phải lớn hơn 0!");
            return false;
        }

        list.add(pet);
        return true;
    }

    public Pet findById(String id) {
        for (Pet pet : list) {
            if (pet.getId().equals(id)) {
                return pet;
            }
        }
        return null;
    }

    public void deleteById(String id) {
        Pet pet = findById(id);
        if (pet != null) {
            list.remove(pet);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Không tìm thấy thú cưng.");
        }
    }
}