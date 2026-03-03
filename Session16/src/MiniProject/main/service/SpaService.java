package MiniProject.main.service;

import MiniProject.main.model.Pet;

import java.util.LinkedList;
import java.util.Queue;

public class SpaService {
    private Queue<Pet> queue = new LinkedList<>();

    public void checkIn(Pet pet) {
        queue.offer(pet);
    }

    public void serveNext() {
        Pet pet = queue.poll();
        if (pet != null) {
            System.out.println("Đang phục vụ: " + pet);
        } else {
            System.out.println("Không có thú cưng trong hàng đợi.");
        }
    }

    public void showQueue() {
        for (Pet pet : queue) {
            System.out.println(pet);
        }
    }
}